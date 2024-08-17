package com.wyz.recursion;

//数字塔
public class DigitTower {

    public static void line(int i, int n)                         //输出一行，递归方法
    {
        System.out.print(String.format("%3d", i));
        if (i < n) {
            line(i + 1, n);
            System.out.print(String.format("%3d", i));
        }
    }

}
