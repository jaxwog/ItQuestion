package com.wyz.design.strategy;

/**
 * com.wyz.design.strategy
 * Created by jax on 2019/11/22 14:47
 * TODO:策略模式，android源码中的属性动画
 * 不同会员出现不同的打折策略，实现抽象策略接口
 */
public class Client {
    public static void main(String[] args) {
        IStrategy strategy = new StrategyInitial();
        MemberContext memberContext = new MemberContext(strategy);
        System.out.println("打折后价格为："+memberContext.caculetor(100));
    }
}
