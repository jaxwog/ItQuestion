package com.wyz.design.iterator;

/**
 * com.wyz.design.iterator
 * Created by jax on 2019/11/24 15:25
 * TODO:容器的接口
 */
public interface IAggregate<T> {
    void add(T t);
    void remove(T t);

    IIterator<T> iterator();

}
