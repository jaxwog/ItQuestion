package com.wyz.design.strategy;

/**
 * com.wyz.design.strategy
 * Created by jax on 2019/11/22 15:07
 * TODO:初级会员，具体策略
 */
public class StrategyInitial implements IStrategy{
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
