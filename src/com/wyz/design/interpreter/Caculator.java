package com.wyz.design.interpreter;

/**
 * com.wyz.design.interpreter
 * Created by jax on 2019/11/19 17:34
 * TODO:计算类
 */
public class Caculator {
    public int  build(String statement){
        INode left = null;
        INode right = null;
        INode lastNode = null;
        String []statements = statement.split(" ");
        for (int i = 0; i < statements.length; i++) {
            if ("*".equalsIgnoreCase(statements[i])){
                left = lastNode;
                int val = Integer.parseInt(statements[++i]);
                right = new ValueNode(val);

                lastNode = new MulNode(left,right);

            }else if ("/".equalsIgnoreCase(statements[i])){
                left = lastNode;
                int val = Integer.parseInt(statements[++i]);
                right = new ValueNode(val);

                lastNode = new DivNode(left,right);

            }else {
                lastNode = new ValueNode(Integer.parseInt(statements[i]));
            }
        }



        return lastNode.interpret();
    }
}
