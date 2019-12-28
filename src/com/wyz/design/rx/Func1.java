package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 18:17
 * TODO:抽象的交换的函数（行为）
 *   T 代表 养羊人的角色
 *   R  代表 打铁人的角色
 */
public interface Func1<T,R> {
    R call(T t);
}
