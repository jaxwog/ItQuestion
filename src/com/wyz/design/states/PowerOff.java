package com.wyz.design.states;

/**
 * com.wyz.design.states
 * Created by jax on 2019/11/22 00:02
 * TODO:具体状态类，关机状态，达到不同状态下不同行为
 */
public class PowerOff implements ITvState {
    @Override
    public void nextChannel() {

    }

    @Override
    public void preChannel() {

    }

    @Override
    public void turnOn() {
        System.out.println("已为你打开电视");
    }

    @Override
    public void turnOff() {

    }
}
