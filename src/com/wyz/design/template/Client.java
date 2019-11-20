package com.wyz.design.template;

/**
 * com.wyz.design.template
 * Created by jax on 2019/11/20 10:14
 * TODO:模板模式，固定的执行流程，具体实现方法在子类中实现
 * 责任链模式也采用这种模式，主要一点是：执行步骤play固定在抽象方法中（final修饰），不允许被篡改或者继承
 * Android中的AsyncTask采用这种方法进行编写
 */
public class Client {
    public static void main(String[] args) {
        AbsGame game = new LolGame();
        game.play();
    }
}
