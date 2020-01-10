package com.wyz.design.proxy;

/**
 * com.wyz.design.proxy
 * Created by jax on 2020/1/7 10:12
 * TODO:通过实现接口，动态代理通过接口进行反射代理
 */
public class RealSubject implements ISubject,ISerivice {
    @Override
    public void request() {
        System.out.println("真正的角色");
    }

    @Override
    public void add() {
        System.out.println("真正的角色的添加方法");
    }
}
