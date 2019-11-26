package com.wyz.design.iterator;

/**
 * com.wyz.design.iterator
 * Created by jax on 2019/11/24 15:18
 * TODO:抽象迭代器接口
 */
public interface IIterator<T> {
    //是否还有下一个元素
    boolean hashNext();
    T next();

}
