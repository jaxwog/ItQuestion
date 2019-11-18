package com.wyz.j2ee;

//生产者消费者问题

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Java 中可以用 wait、notify 和 notifyAll 来实现线程间的通信,
 * 生产者可以通知消费者，让消费者开始消耗数据，因为队列缓冲区中有内容待消费（不为空）
 * 可以利用wait()来让一个线程在某些条件下暂停运行,
 *
 * 如果某些线程在等待某些条件触发，那当那些条件为真时，你可以用 notify 和 notifyAll 来通知那些等待中的线程重新开始运行。
 * 如果只有一个线程在等待一个信号灯，notify和notifyAll都会通知到这个线程。但如果多个线程在等待这个信号灯，那么notify只会通知到其中一个，
 * 而其它线程并不会收到任何通知，而notifyAll会唤醒所有等待中的线程
 *
 * 永远在循环（loop）里调用 wait 和 notify，不是在 If 语句
 *if语句存在一些微妙的小问题，导致即使条件没被满足，你的线程你也有可能被错误地唤醒
 */
public class ProducerConsumer {

    //可以创建对象，直接锁对象
    // Object lock = new Object();

    public static void test(){
        AsyncTask ss = new AsyncTask();
        Producer producer = new Producer(ss);
        Consumer consumer = new Consumer(ss);
        new  Thread(producer).start();
        new Thread(consumer).start();
    }
}

class WoTou{
    int id;
    public WoTou(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "WoTou id = "+id;
    }
}

/**
 * java.lang.IllegalMonitorStateException
 * 1>当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法;
 * 2>当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
 * 3>当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法。
 */

class AsyncTask{
    WoTou[]tous = new WoTou[6];
    static int index = 0;

    //防止执行任务时候被别的方法打断
    public synchronized void push(WoTou woTou){
        while (index==tous.length){
            try {
                //Object中的方法，用来进行线程等待，此时线程锁解开
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Object中的方法，用来唤醒当前对象上其它线程
        this.notify();
        tous[index] = woTou;
        index++;
    }

    public synchronized WoTou flush(){
        while (index==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return tous[index];
    }

}

class Producer implements Runnable{
    AsyncTask ss ;
    public Producer(AsyncTask ss){
        this.ss = ss;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            WoTou woTou = new WoTou(i);
            ss.push(woTou);
            System.out.println(Thread.currentThread().getName()+"生产"+woTou.toString());
            try {
                Thread.sleep((int)(Math.random()*200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable{
    AsyncTask ss ;
    public Consumer(AsyncTask ss){
        this.ss = ss;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            WoTou woTou = ss.flush();
            System.out.println(Thread.currentThread().getName()+"消费"+woTou.toString());
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
