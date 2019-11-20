package com.wyz.design.observer;

/**
 * com.wyz.design.observer
 * Created by jax on 2019/11/20 11:03
 * TODO:抽象观察者
 */
public interface IObserver {
    /**
     * 更新接口
     * @param content
     */
    public void update(String content);
}
