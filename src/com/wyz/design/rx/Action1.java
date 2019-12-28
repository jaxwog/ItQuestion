package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 11:34
 * TODO: 目的  抽象 养羊的人
 * T 铁匠  打铁
 */
public interface Action1<T> {
    //呼唤铁匠打铁的行为
    void call(T t);
}
