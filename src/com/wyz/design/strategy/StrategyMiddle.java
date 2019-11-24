package com.wyz.design.strategy;

/**
 * com.wyz.design.strategy
 * Created by jax on 2019/11/22 15:05
 * TODO:中级会员，具体策略
 */
public class StrategyMiddle implements IStrategy{
    @Override
    public double calculatePrice(double price) {
        return price*0.9;
    }
}
