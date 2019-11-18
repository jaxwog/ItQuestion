package com.wyz.recursion;

/**
 * 递归定义满足以下两个条件
 * 边界条件：至少有一条初始定义是非递归的  1！ =1
 * 递推通式：由已知函数值逐步递推计算出未知函数值 用（n-1）！定义n！
 * 递归算法：存在直接或者间接调用自身的算法
 */

//求n！
public class Factorial {

    public static int factorial(int n){

        if (n<0){
            throw  new IllegalArgumentException("n="+n);   //抛出无效参数异常
        }
        if (n==0 || n==1){      //边界条件
            return 1;
        }
        return n*factorial(n-1);    //递推通式
    }
}
