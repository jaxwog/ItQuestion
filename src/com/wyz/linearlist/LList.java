package com.wyz.linearlist;

public interface LList <T>{
    boolean isEmpty();   //判断线性表是否为空
    int length();                //返回线性表长度
    T get(int i);                 //返回第i号元素
    void set(int i, T x);     //设置第i号元素值为x
    void insert(int i, T x); //插入x作为第i号元素
    void append(T x);      //在线性表最后插入元素x
    T remove(int i);          //删除第i号元素并返回被删除的元素
    void removeAll();      //删除线性表所有元素
    T search(T key);        //查找，返回首次出现关键字为key的元素。

/**
 * 对于非空的线性表（n>0）:
 ① 开始结点a0，没有直接前趋，有且仅有一个直接后继a1；
 ② 终端结点an-1，没有直接后继，有且仅有一个直接前驱an-2；
 ③ 其余的内部结点ai（1≤i≤n-2）都有且仅有一个直接前趋ai-1和一个直接后继ai+1。

 */
}
