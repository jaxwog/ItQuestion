package com.wyz.stack;


import com.wyz.linearlist.SortedSinglyLinkedList;

//优先队列类，实现队列接口，使用排序单链表存储队列元素，元素按优先级升序排列
public class PriorityQueue<T extends Comparable<T>> implements QQueue<T> {
    private SortedSinglyLinkedList<T> list;                //使用排序单链表存储队列元素

    public PriorityQueue()                                 //构造空队列
    {
        this.list = new SortedSinglyLinkedList<T>();
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(T x) {
        list.insert(x);                              //根据元素大小插入在单链表适当位置
    }

    @Override
    public T dequeue() {                          //出队，返回队头元素，若队列空返回null
        return list.remove(0);                   //返回队头元素，删除队头结点
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
