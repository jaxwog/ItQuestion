package com.wyz.design.proxy;

/**
 * com.wyz.design.proxy
 * Created by jax on 2020/1/7 10:15
 * TODO:静态代理  代理者
 * 需要持有一个真实对象
 * 代理模式
 * 被代理的对象就称为真实对象
 */
public class ProxyStatic implements ISubject {

     //真实对象
    private ISubject subject;

    public ProxyStatic(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("代理者开始");
        subject.request();
        System.out.println("代理者结束");
    }
}
