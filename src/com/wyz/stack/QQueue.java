package com.wyz.stack;

/**
 *队列接口，描述队列抽象数据类型
 * 包含判空，入队列，出队列
 */
public interface QQueue<T> {
    boolean isEmpty();
    void enqueue(T x);        //在队列尾部插入x元素
    T dequeue();             //从队列头部取出元素，返回头元素

}
