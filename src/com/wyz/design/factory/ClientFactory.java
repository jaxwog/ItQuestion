package com.wyz.design.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wyz.design.factory
 * Created by jax on 2019/11/5 16:10
 * TODO: 工厂模式
 * Bitmap bitmap = BitmapFatory.deresources(res,id);
 *
 * 场景：创建对象
 * 简单工厂：提供创建对象的功能，不需要关心具体的实现
 *
 * 好处：降低客户端与模块之间的耦合度（最少知识原则）
 *
 * 需求：导出数据
 * 文件：数据库文件、文本文件
 *
 *
 * 工厂方法：把对象的实现延迟到子类完成
 */
public class ClientFactory {
    public static void main(String[] args) {
        FactoryAbs factory = new ConcreteFactory();
//      ProductInterface file =   factory.newProductInterface();
//      file.export("hhhhh");
        factory.export("。。。。。");

        factory.newProductInterface(ProductFile.class);
        factory.export("hahha");

        //List Creator 工厂
        //ArrayList ConcreteCreator具体的创建者 （具体工厂）
        List<String> list = new ArrayList<String>();
        list.iterator();//交给具体的子类（ArrayList）进行生产

        //Iterator Product 产品接口
        //ArrayListIterator ConcreteProduct具体的产品
    }
}
