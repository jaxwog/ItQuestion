package com.wyz.design.template;

/**
 * com.wyz.design.template
 * Created by jax on 2019/11/20 10:09
 * TODO:模板模式抽象类，定义了一套算法框架
 * final修饰方法，防止方法被修改
 */
public abstract class AbsGame {

        abstract void initialize();
        abstract void startPlay();
        abstract void endPlay();


        public final void play()
        {
            System.out.println("游戏开机");
            //初始化游戏
            initialize();

            //开始游戏
            startPlay();

            //结束游戏
            endPlay();

            System.out.println("游戏关机");

        }
}
