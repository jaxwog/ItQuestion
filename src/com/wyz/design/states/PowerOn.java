package com.wyz.design.states;

/**
 * com.wyz.design.states
 * Created by jax on 2019/11/22 00:05
 * TODO:具体状态类，开机状态，达到不同状态下不同行为
 */
public class PowerOn implements ITvState {
    @Override
    public void nextChannel() {
        System.out.println("已经切换下一个频道");
    }

    @Override
    public void preChannel() {
        System.out.println("已经切换上一个频道");
    }

    @Override
    public void turnOn() {
        System.out.println("开机啦");
    }

    @Override
    public void turnOff() {
        System.out.println("已关机");
    }
}
