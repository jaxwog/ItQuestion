package com.wyz.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wyz.design.iterator
 * Created by jax on 2019/11/24 15:20
 * TODO:具体的迭代角色,间谍
 */
public class ConcreteIterator<T> implements IIterator<T> {


    private List<T> mList = new ArrayList<>();
    private int cursor = 0;

    public ConcreteIterator(List<T> list) {
        mList = list;
    }

    @Override
    public boolean hashNext() {
        return cursor != mList.size();
    }

    @Override
    public T next() {
        T obj = null;
        if (this.hashNext()){
            obj = mList.get(cursor++);
        }
        return obj;
    }
}
