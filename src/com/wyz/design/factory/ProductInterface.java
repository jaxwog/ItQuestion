package com.wyz.design.factory;

/**
 * com.wyz.design.factory
 * Created by jax on 2019/11/5 15:59
 * TODO: 工厂模式中 产品类的接口，由具体的产品类去实现
 * 定义一个用于创建对象的接口，让子类决定实例化哪个类
 * 使用场景：任何需要生成复杂对象的地方都可以用
 */
public interface ProductInterface {
   void export(String data);
}
