package com.wyz.design.moblie;

/**
 * com.wyz.design.moblie
 * Created by jax on 2019/11/7 10:19
 * TODO: 个人订单
 */
public class PersonOrder implements IOrder {

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
        //隐藏复制过程
        PersonOrder personOrder = new PersonOrder();
        personOrder.setOderNumber(oderNumber);
        personOrder.setName(name);
        return personOrder;

    }
}
