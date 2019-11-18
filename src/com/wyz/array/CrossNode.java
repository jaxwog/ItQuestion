package com.wyz.array;

/**
 * 十字链表结点类
 */
public class CrossNode {
    Element data;           //数据域表示三元组，默认访问权限
    CrossNode right,down;        //right指向行的下一个结点，down指向列的下一个结点

    public CrossNode(Element data,CrossNode right,CrossNode down){
        this.data = data;
        this.right = right;
        this.down = down;
    }
}
