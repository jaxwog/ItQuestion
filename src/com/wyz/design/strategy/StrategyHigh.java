package com.wyz.design.strategy;

/**
 * com.wyz.design.strategy
 * Created by jax on 2019/11/22 15:03
 * TODO:高级会员，具体策略
 */
public class StrategyHigh implements IStrategy {
    @Override
    public double calculatePrice(double price) {
        return price*0.8;
    }
}
