package com.wyz.linearlist;

/**
 * 双链表节点类
 * head.next==null时，双链表为空
 * 当p为非两端结点时，始终有：p == p.prev.next == p.next.prev
 * <p>
 * 从语法上DLinkNode<T>可以声明如下，但双链表结点与单链表结点，并不是两个具有包含关系的概念。
 * public class DLinkNode<T> extends Node<T>
 * super();  父类中next类型为Node<T>，结点结构不对，且没有prev域
 */
public class DLinkNode<T> {
    public T data;
    public DLinkNode<T> prev, next;                 //prev指向前驱结点，next指向后继结点

    public DLinkNode(T data, DLinkNode<T> prev, DLinkNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DLinkNode() {
        this(null, null, null);
    }

    public DLinkNode(T data) {
        this(data, null, null);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }


}
