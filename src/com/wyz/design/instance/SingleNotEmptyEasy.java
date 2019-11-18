package com.wyz.design.instance;

/**
 * com.wyz.design.instance
 * Created by jax on 2019/11/7 15:58
 * TODO:单例模式 懒汉模式 每次调用getInstance时 synchronized 都需要进行同步开销（第二个线程需要等到第一个解锁，实际上不为空直接返回就行）
 * 谁用谁加载，线程不安全
 */
public class SingleNotEmptyEasy {
    private static SingleNotEmptyEasy singleEasy ;
    private SingleNotEmptyEasy(){

    }
    public static synchronized SingleNotEmptyEasy getInstance(){
        if (singleEasy==null){
            singleEasy = new SingleNotEmptyEasy();
        }
        return singleEasy;
    }
}
