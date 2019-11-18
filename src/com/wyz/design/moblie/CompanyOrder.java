package com.wyz.design.moblie;

/**
 * com.wyz.design.moblie
 * Created by jax on 2019/11/7 10:33
 * TODO: 公司订单
 */
public class CompanyOrder implements IOrder {
    private int oderNumber;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getOderNumber() {
        return oderNumber;
    }

    @Override
    public void setOderNumber(int number) {
        this.oderNumber = number;
    }

    @Override
    public Prototype cloneOrder() {
        CompanyOrder order=new CompanyOrder();
        order.setName(this.name);
        order.setOderNumber(this.oderNumber);
        return order;
    }
}
