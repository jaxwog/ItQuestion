package com.wyz.test;

public class Dog {
    private String name;
    private int age;
    static {
        System.out.println("Dog is load");
    }

    private void print(){
        System.out.println("print ...");
    }

    public Dog(String name,int age){
        this.name = name;
        this.age = age;
    }
}
