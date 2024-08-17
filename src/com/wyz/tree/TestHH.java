package com.wyz.tree;

public class TestHH extends BinaryTree {

    public TestHH() {
        BinaryTree binaryTree = new BinaryTree();
    }

    @Override
    void getHH() {
        super.getHH();
        System.out.println("我是重写的方法啊");
    }
}
