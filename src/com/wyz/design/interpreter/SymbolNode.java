package com.wyz.design.interpreter;

/**
 * com.wyz.design.interpreter
 * Created by jax on 2019/11/19 17:25
 * TODO:非终结符抽象类，由子类实现具体的乘或除运算
 */
public abstract class SymbolNode  implements INode{
    protected INode left;
    protected INode right;

    public SymbolNode(INode left, INode right) {
        this.left = left;
        this.right = right;
    }

}
