package com.wyz.stack;

/**
 * 关于栈的应用：适配括号，十进制转化为N进制
 */
public class UtilStack {

    /**
     * 用来判断字符串中小括号是否左右相等符合运算法则
     */
    public static String isvalid(String expstr) {
        SeqStack<String> stack = new SeqStack<String>(expstr.length());

        for (int i = 0; i < expstr.length(); i++) {
            char ch = expstr.charAt(i);

            switch (ch) {
                case '(':
                    stack.push(ch + "");
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return "期望(";
                    } else {
                        stack.pop();
                    }
                    break;
            }

        }
        if (stack.isEmpty()) {
            return "匹配成功";
        } else {
            return "期望）";

        }
    }

    /**
     * 将十进制数N除以d，得到一个商数（N1=N/d）和一个余数（r1=N％d）；
     * 再将十进制数N1除以d，又得到一个商数（N2=N1/d）和一个余数（r2=N1％d）；
     * 继续这个过程，直到商数为0为止。每次得到的余数就是对应d进制的各位数字。
     * 最后一次相除得到的余数为d进制数的最高位，第一次相除得到的余数为d进制数的最低位
     */
    public static String TransportNum(int N, int d) {
        if (d <= 0) {
            return null;
        }
        System.out.print("(" + N + ")10 = (");
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        while (N != 0) {
            int r;
            r = N % d;
            N = N / d;
            stack.push(new Integer(r));
        }
        String str = "";
        while (!stack.isEmpty()) {
            str += stack.pop();     //如果d为16，需要把出栈的余数大于9的数据转换为A、B、C、D、E、F
        }
        System.out.println(str + ")" + d);

        return str;
    }
}
