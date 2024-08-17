package com.wyz.design.annotation;

@Description("i am Class annotation")
public class Child implements Person {

    @Description("i am Method annotation")
    @Override
    public String name() {
        return "";
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void song() {
        System.out.println("i am Child song!");

    }

    @Override
    public String eat(int price, String food) {
        System.out.println("price is " + price + " and food is " + food);
        return "price is " + price + " and food is " + food;
    }
}
