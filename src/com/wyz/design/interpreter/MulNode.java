package com.wyz.design.interpreter;

/**
 * com.wyz.design.interpreter
 * Created by jax on 2019/11/19 17:29
 * TODO:计算乘法
 */
public class MulNode extends SymbolNode {
    public MulNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}
