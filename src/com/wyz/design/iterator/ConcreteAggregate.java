package com.wyz.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wyz.design.iterator
 * Created by jax on 2019/11/24 15:28
 * TODO:具体的容器，军队
 */
public class ConcreteAggregate<T> implements IAggregate<T> {
    private List<T> list=new ArrayList<>();
    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public IIterator<T> iterator() {
        return new ConcreteIterator<>(list);
    }
}
