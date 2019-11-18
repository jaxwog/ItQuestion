package com.wyz.stack;

import com.wyz.linearlist.Node;

/**
 *链式队列（队列的链式存储结构），限制仅在表头删除，表位插入的单链表
 *toString时间复杂度为O(n)，其它方法为O(1)
 */
public class LinkedQueue<T>implements QQueue<T> {
    private Node<T> front,rear;                  //front和rear分别指向队头和队尾结点

    public LinkedQueue(){                         //构造空队列
        this.front = this.rear =null;
    }

    @Override
    public boolean isEmpty() {            //判断列表是否为空
        return this.front==null && this.rear==null;
    }

    @Override
    public void enqueue(T x) {
        if (x==null){
            return;
        }
        Node<T> q = new Node<T>(x,null);
        if (this.front==null){
            this.front = q;            //如果队列为空，在队头插入数据
        }else {
            this.rear.next = q;        //否则在队尾插入结点q
        }
        this.rear = q;       //重置尾结点为插入的结点

    }

    @Override
    public T dequeue() {
       if (isEmpty()){
           return null;
       }
       T temp = this.front.data;
       this.front = this.front.next;     //取得队头元素，删除队头结点
       if (this.front==null){
           this.rear = null;
       }
        return temp;
    }

    @Override
    public String toString() {
        String str = "(";
        for (Node<T> p = this.front;p!=null;p = p.next){
            str += p.data.toString();
            if (p.next!=null){
                str += ", ";
            }
        }
        return str + "）";
    }
}
