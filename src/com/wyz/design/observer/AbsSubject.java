package com.wyz.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wyz.design.observer
 * Created by jax on 2019/11/20 11:00
 * TODO:抽象主题，被观察者
 */
public abstract class AbsSubject {
    /**
     * 保存注册观察者对象
     */
    private List<IObserver> list=new ArrayList<>();


    /**
     * 添加观察者
     * @param observer
     */
    public void attach(IObserver observer) {
        list.add(observer);
    }

    /**
     * 删除观察者
     * @param observer
     */
    public void detach(IObserver observer) {
        list.remove(observer);
    }

    /**
     * 更新所有注册的观察者
     * @param content
     */
    public  void notifyObservers(String content) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).update(content);
        }
    }


}
