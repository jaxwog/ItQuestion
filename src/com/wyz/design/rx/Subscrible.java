package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 11:24
 * TODO:角色 ：铁匠
 * 养羊的人 通知了  铁匠 打铁
 * 观察者
 * T  代表具备的能力    会用铁做生活用具
 */
public abstract class Subscrible<T> {

    //T  t
    //开始打铁
    public abstract void onNext(T t);
}
