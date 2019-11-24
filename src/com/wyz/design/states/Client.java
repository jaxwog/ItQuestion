package com.wyz.design.states;

/**
 * com.wyz.design.states
 * Created by jax on 2019/11/21 23:58
 * TODO:状态模式
 * 用对象充当状态，省却大部分的if。。else判断
 * 不清楚具体的内部细节，调用方法不变
 * 策略模式是需要清楚具体细节，传入不同的细节进行差异化处理
 */
public class Client {
    public static void main(String[] args) {
        TvContext tvContext=new TvContext();
        tvContext.nextChannel();

        tvContext.turnOn();
        tvContext.nextChannel();
        tvContext.preChannel();
        tvContext.turnOff();
    }
}
