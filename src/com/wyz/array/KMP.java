package com.wyz.array;

import java.util.Arrays;

/**
 * com.wyz.array
 * Created by jax on 2020/4/20 13:44
 * TODO:KMP字符串匹配算法
 * 时间复杂度m+n，  i是目标串指针（i指针一直向后移动，不进行回溯），j是模式串指针，
 * KMP 算法永不回退 txt 的指针 i，不走回头路（不会重复扫描 txt），而是借助 dp 数组中储存的信息把 pat 移到正确的位置继续匹配
 */
public class KMP {
    public static void main(String[] args) {
        String str="ababcabcbababcabacaba";
        String dest="ababcaba";
        int[] array=kmpNext(dest);
        System.out.println(Arrays.toString(array));

        System.out.println(kmp(str,dest,array));
    }

    /**
     *
     * @param str 目标串
     * @param dest 模式串
     * @param next 计算这个 next 数组，只和 pat 串有关
     * @return 字符串匹配的起始位置信息
     */
    private static int kmp(String str,String dest,int[] next){
        for (int i = 0,j=0; i < str.length(); i++) {
            System.out.println("========================"+i);
            while (j>0 && str.charAt(i)!=dest.charAt(j)){
                j = next[j-1];
                System.out.println("j和i不同后 == "+j);
            }

            if (str.charAt(i)==dest.charAt(j)){
                j++;
                System.out.println("j++后 == "+j);
            }

            if (j==dest.length()){
                return i-j+1;
            }

        }

        return -1;
    }


    /**
     * 获取到next数组字符串  计算这个 next 数组，只和 pat 串有关
     * @param dest 模式串（比较短的）
     * @return
     *
     */
    private static int[] kmpNext(String dest){
        int[] next=new int[dest.length()];
        next[0]=0;
        for (int i = 1,j = 0; i < dest.length(); i++) {
//3
            while (j > 0 && dest.charAt(i)!=dest.charAt(j)){
                j = next[j-1];
            }
    //1
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
//2
            next[i] = j;

        }

        return next;
    }



}
