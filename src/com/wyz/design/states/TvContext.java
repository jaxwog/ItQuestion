package com.wyz.design.states;

/**
 * com.wyz.design.states
 * Created by jax on 2019/11/22 00:10
 * TODO:环境类，默认状态为关机状态
 */
public class TvContext {
    private ITvState tvState=new PowerOff();
    public void setTate(ITvState tvState) {
        this.tvState=tvState;
    }

    public void turnOn() {
        setTate(new PowerOn());
        System.out.println("开机啦");
    }

    public void turnOff() {
        setTate(new PowerOff());
        System.out.println("关机啦");
    }

    public void nextChannel() {
        tvState.nextChannel();
    }
    public void preChannel() {
        tvState.preChannel();
    }
}
