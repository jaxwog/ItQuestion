package com.wyz.design.interpreter;

/**
 * com.wyz.design.interpreter
 * Created by jax on 2019/11/19 18:18
 * TODO:解释器模式
 */
public class Client {
    public static void main(String[] args) {
        String context = "3 * 5 * 7 / 3";
        Caculator caculator = new Caculator();
      int result =   caculator.build(context);
      System.out.println("======="+result);

    }
}
