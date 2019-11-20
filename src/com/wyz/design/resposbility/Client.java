package com.wyz.design.resposbility;

/**
 * com.wyz.design.resposbility
 * Created by jax on 2019/11/15 15:31
 * TODO:责任链模式
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。
 * 将这些对象形成一个链，并沿着这条链传递该请求，直到有对象处理它为止。
 *
 */
public class Client {

    public static void main(String[] args) {
        //确定链式关系
        AbstractHandler handler1=new Handler1();
        AbstractHandler handler2=new Handler2();
        AbstractHandler handler3=new Handler3();
        handler1.nextHandler=handler2;
        handler2.nextHandler=handler3;

        AbstractRequest request = new Request3("请求3");
        handler1.handleRequest(request);

    }
}
