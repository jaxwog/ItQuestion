package com.wyz.array;

/**
 * 广义表双链表示的结点类
 */
public class GenListNode<T> {
    public T data;                       //数据域
    public GenList<T>child;              //地址域，指向子表
    public GenListNode<T>next;         //地址域，指向后继结点


    public GenListNode(T data,GenList<T> child,GenListNode<T> next){
        this.data = data;
        this.child =child;
        this.next = next;
    }
    public GenListNode(T data){
        this(data,null,null);
    }

    public GenListNode(){
        this(null);
    }
}
