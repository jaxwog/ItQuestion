package com.wyz.design.interpreter;

/**
 * com.wyz.design.interpreter
 * Created by jax on 2019/11/19 17:23
 * TODO:终结符 不能够被分解
 */
public class ValueNode implements INode {
    private int value;

  public  ValueNode(int value){
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}
