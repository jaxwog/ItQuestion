package com.wyz.design.observer;

/**
 * com.wyz.design.observer
 * Created by jax on 2019/11/20 11:19
 * TODO:观察者模式
 * 被观察者提供一个集合保存观察者，提供添加删除方法，提供通知每个观察者的方法
 */
public class Client {
    public static void main(String[] args) {
        AbsSubject subject=new ConcreteSubject();
        IObserver observer1=new ConcreteObserver("观察者一");
        IObserver observer2=new ConcreteObserver("观察者二");
        IObserver observer3=new ConcreteObserver("观察者三");
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);
        subject.notifyObservers("被观察者 发生了变化");
//        subject.detach(observer1);
//        subject.notifyObservers("被观察者 发生了变化");
    }
}
