package com.wyz.design.resposbility;

/**
 * com.wyz.design.resposbility
 * Created by jax on 2019/11/15 15:31
 * TODO:
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
