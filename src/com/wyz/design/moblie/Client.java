package com.wyz.design.moblie;

/**
 * com.wyz.design.moblie
 * Created by jax on 2019/11/7 10:35
 * TODO: 调用原型模式
 */
public class Client {
    public static void main(String[] args) {
        OrderDealFactory orderDealFactory=new OrderDealFactory();
        PersonOrder order = new PersonOrder();
        order.setOderNumber(3500);
        order.setName("个人订单");
        orderDealFactory.dealOrder(order);
    }

}
