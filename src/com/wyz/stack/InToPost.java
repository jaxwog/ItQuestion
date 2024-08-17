package com.wyz.stack;


import java.util.Stack;

/**
 * com.wyz.stack
 * Created by jax on 2020/4/22 13:40
 * TODO:逆波兰表达式
 * 数字输出，运算符进栈，括号匹配出栈，当前要放入的符号比栈顶优先级低则栈顶出栈，当前的入栈再比较（ + - *  /）
 * 中缀表达式 9+（3-1）*3+8/2 = 19 转后缀931-3*+8 2/+
 */
public class InToPost {
    public static void main(String[] args) {
        String s = resultSuffix("9+(3-1)*3+8/2");
        resultAnswer(s);


    }


    //中缀表达式转换为后缀表达式
    public static String resultSuffix(String f) {
        Stack<Character> stackNum = new Stack<>();
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < f.length(); i++) {
            char a = f.charAt(i);
            if (a == '+' || a == '-') {
                if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    result = result + stack.pop();
                }
                while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
                    result = result + stack.pop();
                }
                stack.push(a);
            }
//           else if (a=='-'){
//               stack.push(a);
//           }
            else if (a == '*' || a == '/') {
                stack.push(a);
            } else if (a == '(') {
                stack.push(a);
            } else if (a == ')') {
                char b = 0;
                while (b != '(') {
                    b = stack.pop();
                    System.out.println("====：" + b);
                    if (b != '(') {
                        result = result + b;
                    }
                }

            } else {
                result = result + a;

            }
            System.out.println("每一步====：" + result);
        }
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }


        System.out.println("中缀表达式转后缀表达式：" + result);
        return result;
    }


    //根据后缀表达式获取结果
    public static void resultAnswer(String suffix) {
        if (suffix.isEmpty()) return;
        Stack<String> stack = new Stack<>();
        int content1;
        int content2;
        int result = -1;

        for (int i = 0; i < suffix.length(); i++) {
            if (suffix.charAt(i) == '+') {
                content2 = Integer.parseInt(stack.pop());
                content1 = Integer.parseInt(stack.pop());
                result = content1 + content2;
                System.out.println(content1 + "+" + content2);
                stack.push(result + "");
            } else if (suffix.charAt(i) == '-') {
                content2 = Integer.parseInt(stack.pop());
                content1 = Integer.parseInt(stack.pop());
                result = content1 - content2;
                System.out.println(content1 + "-" + content2);
                stack.push(result + "");
            } else if (suffix.charAt(i) == '*') {
                content2 = Integer.parseInt(stack.pop());
                content1 = Integer.parseInt(stack.pop());
                result = content1 * content2;
                System.out.println(content1 + "*" + content2);
                stack.push(result + "");
            } else if (suffix.charAt(i) == '/') {
                content2 = Integer.parseInt(stack.pop());
                content1 = Integer.parseInt(stack.pop());
                result = content1 / content2;
                System.out.println(content1 + "/" + content2);
                stack.push(result + "");
            } else {
                System.out.println("" + suffix.charAt(i));
                stack.push(String.valueOf(suffix.charAt(i)));
            }
        }

        System.out.println("输出结果内容为：" + result);


    }

}
