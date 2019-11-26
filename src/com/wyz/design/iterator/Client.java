package com.wyz.design.iterator;

/**
 * com.wyz.design.iterator
 * Created by jax on 2019/11/24 15:31
 * TODO:迭代器模式，不常用
 */
public class Client {
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate();
        aggregate.add("张三");
        aggregate.add("李四");
        aggregate.add("王五");
        IIterator iIterator = aggregate.iterator();
        while (iIterator.hashNext()){
            System.out.println(iIterator.next());
        }
    }
}
