package com.wyz.test;

public class T {
    static {
        System.out.println("T^T");
    }

    public T(){
        System.out.println("T is load");
    }

    String string;
    int i;

    public void m1(int i,int j){
        this.i = i;
        System.out.println("add sum="+(i+j));
    }

    public String getString() {
        return string;
    }

    public void m(){
        System.out.println("");
        System.out.println("m invoked");
        System.out.println("");
    }



}
