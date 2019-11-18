package com.wyz.design.factory;

/**
 * com.wyz.design.factory
 * Created by jax on 2019/11/5 16:00
 * TODO: 工厂方法 具体的产品类 文件
 */
public class ProductFile implements ProductInterface {
    @Override
    public void export(String data) {
        System.out.println("设置类型为：文件"+data);
    }
}
