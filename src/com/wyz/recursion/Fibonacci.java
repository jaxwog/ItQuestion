package com.wyz.recursion;

//斐波那契数列
public class Fibonacci {


    public static int fib(int n) {
        //返回斐波那契数列第n项数据
        if (n < 0) {
            throw new IllegalArgumentException("n=" + n);
        }

        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 2) + fib(n - 1);
    }
}
