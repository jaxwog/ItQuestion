package com.wyz.design.factory;

/**
 * com.wyz.design.factory
 * Created by jax on 2019/11/5 16:08
 * TODO: 工厂模式 具体工厂类 生产具体的产品的工厂
 * 实现了具体的业务逻辑
 * 如果创建方法为static 表示简单工厂或者静态工厂
 */
public class ConcreteFactory extends FactoryAbs {
    @Override
    public ProductInterface newProductInterface() {
        return new ProductFile();
    }

    @Override
    public <T extends ProductInterface> T newProductInterface(Class<T> clz) {
        ProductInterface p = null;

        try {
            p = (ProductInterface) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T) p;
    }

}
