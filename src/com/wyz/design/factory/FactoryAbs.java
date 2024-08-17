package com.wyz.design.factory;

/**
 * com.wyz.design.factory
 * Created by jax on 2019/11/5 16:02
 * TODO: 工厂模式 抽象工厂类
 * 工厂方法模式的核心
 */
public abstract class FactoryAbs {

    /**
     * @return （没办法复用）具体生产什么由子类去实现
     */
    public abstract ProductInterface newProductInterface();

    public abstract <T extends ProductInterface> T newProductInterface(Class<T> clz);

    /**
     * 导出数据（可以复用的方法）
     *
     * @param data
     */
    public void export(String data) {
        ProductInterface api = newProductInterface();
        api.export("工厂模式" + data);

    }
}
