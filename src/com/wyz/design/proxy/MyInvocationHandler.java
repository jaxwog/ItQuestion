package com.wyz.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * com.wyz.design.proxy
 * Created by jax on 2020/1/7 10:32
 * TODO: 动态代理 发生在运行时
 * 处理代理实例上的方法调用并返回结果。此方法将在调用处理程序上调用
 * 当一个方法在一个代理实例上被调用时
 * 联系在一起。
 */
public class MyInvocationHandler implements InvocationHandler {

    //真实对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理方法被执行的时候，都会调用invoke， 需要代理就走真实对象方法
     *
     * 每个代理实例都有一个关联的调用处理程序。
     * 当在代理实例上调用方法时，
     * 该方法调用被编码并发送到调用方调用处理程序的方法。
     */
    /**
     *
     * @param proxy 方法所调用的代理实例 代理对象 iSubject
     * @param method 对应的方法实例在代理实例上调用的接口方法。
     *               声明方法对象的类将是方法的实现接口代理类通过代理接口继承方法
     *               request();
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理=======开始");
        //需要代理，
        Object result = method.invoke(target,args);
        //不需要代理
//        Object result = method.invoke(proxy,args);
        System.out.println("动态代理=======结束");
        return result;
    }
}
