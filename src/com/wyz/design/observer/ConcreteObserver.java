package com.wyz.design.observer;

/**
 * com.wyz.design.observer
 * Created by jax on 2019/11/20 11:04
 * TODO:具体观察者
 */
public class ConcreteObserver implements IObserver {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String content) {
        System.out.println(name+":   "+content);
    }
}
