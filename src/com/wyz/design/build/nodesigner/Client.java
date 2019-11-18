package com.wyz.design.build.nodesigner;

/**
 * com.wyz.design.build.nodesigner
 * Created by jax on 2019/11/15 10:03
 * TODO:构建者模式，省略了原有的设计者，工人抽象接口进行了省略
 * 常用的构建者模式变形设计：大部分源码采用变形方式进行设计
 */
public class Client {
    public static void main(String[] args) {
        Room room = new WorkBuilder().makeDoor("拱形门").makeWindow("落地窗").makeFloor("苍穹顶").build();
        System.out.println(room);
    }
}
