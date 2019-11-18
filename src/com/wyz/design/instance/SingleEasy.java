package com.wyz.design.instance;

/**
 * com.wyz.design.instance
 * Created by jax on 2019/11/7 15:56
 * TODO:单例模式： 第一步加载class文件就已经实例化了，没有做到想用时才实例化
 * 线程安全的，启动慢
 */
public class SingleEasy {
    private static SingleEasy sSingleEasy = new SingleEasy();
}
