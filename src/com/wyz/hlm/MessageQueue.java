package com.wyz.hlm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消息队列，提供消息入队，出队
 * 实现采用数组的方式进行存储
 * 消息是在主线程创建的（初始化），在子线程中发出的消息，在主线程中轮询消息队列处理消息
 * <p>
 * 1、消息队列有大小的限制
 * 2、消息队列满了，子线程停止发送消息，子线程阻塞
 * 3、消息队列为空，主线程停止取消息（Looper停止轮询），主线程阻塞
 * <p>
 * 为什么不用监听器（监听到需要调用后会马上调用）
 * 轮询器是典型的生产者消费者模式（可以有存货，消息队列里面的消息）
 */
public class MessageQueue {

    Message[] items;

    //出队，入队时候索引使用
    int putIndex;
    int takeIndex;
    //队列中有多少消息
    int count;

    //互斥锁
    private Lock lock;
    /**
     * lock相当于代码块加锁
     * synchronized (queue){
     * while (count==items.length){
     * try {
     * notFull.await();
     * queue.wait();
     * } catch (InterruptedException e) {
     * e.printStackTrace();}
     * }
     * }
     */
    //条件变量,选择性解锁
    private Condition notEmpty;
    private Condition notFull;


    public MessageQueue() {
        this.items = new Message[50];
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    /**
     * 加入队列（子线程运行）
     * 生产
     *
     * @param msg
     */
    public void enqueueMessage(Message msg) {
        System.out.println("消息加入队列" + msg.obj.toString());
        try {
            lock.lock();

            //消息队列满了，子线程停止发消息，阻塞
            /**
             * X    为主线程
             * A B C D E 为子线程，可能出现子线程间相互唤醒
             * 采用while可以在执行一遍，防止if出现一遍
             */
            while (count == items.length) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            items[putIndex] = msg;
            //循环取值
            putIndex = (++putIndex == items.length) ? 0 : putIndex;
            count++;
            //有新的Message对象，通知主线程（消费者）
//            notEmpty.signal();//唤醒同类
            notEmpty.signalAll();//唤醒同类时，也唤醒了异类

        } finally {
            lock.unlock();
        }
    }

    /**
     * 出队列（主线程运行）
     * 消费
     *
     * @return
     */
    public Message next() {
        Message msg = null;
        try {
            lock.lock();
            while (count == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            msg = items[takeIndex];
            //消息取出来之后，元素置空
            items[takeIndex] = null;
            takeIndex = (++takeIndex == items.length) ? 0 : takeIndex;
            count--;
            //使用了一个Message对象，通知子线程，可以继续生产了
            notFull.signalAll();


        } finally {
            lock.unlock();
        }
        return msg;
    }

    //阻塞队列
    BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(50);

    public void enqueueMessageb(Message message) {
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //从消息队列中取出消息
    public Message nextb() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
