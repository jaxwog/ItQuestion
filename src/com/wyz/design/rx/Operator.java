package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 23:21
 * TODO:
 * T 羊 Subscrible<? super T> 代表养羊人的角色
 * R 铁 Subscrible<? super  R> 代表打铁人的角色
 */
public interface Operator <T,R> extends Func1<Subscrible<? super T>,Subscrible<? super  R>>{

}
