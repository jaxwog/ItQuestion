package com.wyz.design.interpreter;

/**
 * com.wyz.design.interpreter
 * Created by jax on 2019/11/19 17:32
 * TODO:除法
 */
public class DivNode extends SymbolNode {
    public DivNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() / right.interpret();
    }
}
