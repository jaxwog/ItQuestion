package com.wyz.design.strategy;

/**
 * com.wyz.design.strategy
 * Created by jax on 2019/11/22 15:08
 * TODO:用来操作策略的上下文环境
 */
public class MemberContext {
    private IStrategy mStrategy;

    public MemberContext(IStrategy strategy) {
        mStrategy = strategy;
    }

    public double caculetor(double price){
        return mStrategy.calculatePrice(price);
    }
}
