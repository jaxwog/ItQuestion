package com.wyz.design.moblie;

/**
 * com.wyz.design.moblie
 * Created by jax on 2019/11/7 10:16
 * TODO: 订单接口
 */
public interface IOrder extends Prototype{
    //获取订单数量
    int getOderNumber();

    //设置订单数量
    void setOderNumber(int number);

}
