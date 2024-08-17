package com.wyz.stack;

import com.wyz.linearlist.Node;

/**
 * 链式栈，插入，删除只能在链表的一端进行
 * 采用不带头结点的单链表实现链式栈
 */
public class LinkedStack<T> implements SStack<T> {

    public Node<T> top;          //栈顶结点

    public LinkedStack() {      //构造空栈
        this.top = null;
    }

    @Override
    public boolean isEmpty() {       //判断栈是否为空
        return this.top == null;
    }

    @Override
    public void push(T x) {
        if (x != null) {
            this.top = new Node<T>(x, this.top);    //头插入，x结点作为新的栈顶结点
        }

    }

    @Override
    public T pop() {               //出栈，返回栈顶元素，若栈空返回null
        if (this.top == null) {
            return null;
        }
        T temp = this.top.data;       //取出栈顶结点元素
        this.top = this.top.next;    //删除栈顶结点
        return temp;
    }

    @Override
    public T get() {         //取栈顶元素，未出栈，若栈空返回null
        return this.top == null ? null : this.top.data;
    }

    @Override
    public String toString() {     //返回栈所有元素的描述字符串，形式为“(,)”。算法同不带头结点的单链表
        String str = "(";
        for (Node<T> p = this.top; p != null; p = p.next) {
            str += p.data.toString();
            if (p.next != null) {
                str += ",";
            }
        }
        return str + ")";

    }
}
