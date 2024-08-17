package com.wyz.array;

/**
 * 广义表抽象数据类型
 * 广义表元素个数n称为广义表长度
 * 深度：表中所含括号的层数，原子的深度为0，空表的深度为1
 * 递归表的长度是有限值n，深度是无穷值
 * 大写字母表示表，小写字母表示原子
 */
public interface GGenList<T> {
    /*           */

    //判断广义表是否为空
    boolean isEmpty();

    int length();                  //返回广义表长度

    int depth();                    //返回广义表深度

    GenListNode<T> insert(int i, T x);     //插入原子x作为第i个元素

    GenListNode<T> insert(int i, GenList<T> glist);     //插入子表作为第i个元素

    void remove(int i);                   //删除第i个元素
}