package com.wyz.design.strategy;

/**
 * com.wyz.design.strategy
 * Created by jax on 2019/11/22 15:00
 * TODO:抽象打折接口，返回打折后价格
 */
public interface IStrategy {
     double calculatePrice(double price);
}
