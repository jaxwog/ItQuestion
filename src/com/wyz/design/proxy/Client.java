package com.wyz.design.proxy;

import java.lang.reflect.Proxy;

/**
 * com.wyz.design.proxy
 * Created by jax on 2020/1/7 10:14
 * TODO: 代理：静态代理、动态代理
 *
 * 动态代理具体步骤：
 *
 * 通过实现 InvocationHandler 接口创建自己的调用处理器；
 * 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
 * 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 * 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
 */
public class Client {
    //静态代理
    public static void main(String[] args) {
        System.out.println("static============start==============");
        RealSubject subject = new RealSubject();
        ProxyStatic proxy = new ProxyStatic(subject);
        proxy.request();
        System.out.println("static============end==============");

        System.out.println("dynamic============start==============");
        MyInvocationHandler handler = new MyInvocationHandler(subject);
        /**
         * 实例化一个代理对象 iSubject  ，最后交给handler去处理
         * 第一个参数  classLoader contextLoader
         * 第二个参数   接口数组   决定着返回的对象实现了哪些接口
         * 第三个参数 	MyInvocationHandler 代理时 需要处理具体的操作
         */
        ISubject iSubject = (ISubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                ,subject.getClass().getInterfaces(),handler);
        iSubject.request();

        System.out.println("dynamic============end==============");
    }


}
