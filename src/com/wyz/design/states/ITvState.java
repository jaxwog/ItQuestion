package com.wyz.design.states;

/**
 * com.wyz.design.states
 * Created by jax on 2019/11/22 00:00
 * TODO:表示该状态下的行为
 */
public interface ITvState {
    public void nextChannel();

    public void preChannel();

    public void  turnOn();

    public void turnOff();
}
