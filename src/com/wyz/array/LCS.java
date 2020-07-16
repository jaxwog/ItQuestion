package com.wyz.array;

import java.util.Stack;

/**
 * 动态规划
 * 求两个字符串最长子序列（顺序相同，可以不连续）
 */
public class LCS {


    public static void main(String [] args){
        LCS lcs = new LCS();
        int findLCS = lcs.findLCS("android", "random");
        System.out.println("最长子序列长度："+findLCS);

        getLCS("android", "random");

        /**
         * 最长子序列为4，取右下角的值，动态规划最后结果受前面步骤影响
         0 1 1 1 1 1
         0 1 2 2 2 2
         0 1 2 3 3 3
         1 1 2 3 3 3
         1 1 2 3 4 4
         1 1 2 3 4 4
         1 1 2 3 4 4
         */
    }


    /**
     * 求出两个字符串最长子序列
     */
    public int findLCS(String A,String B){
        int n = A.length();
        int m = B.length();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int [][] ab = new int[n][m];

        //设置第一列数据
        for (int i = 0; i < n; i++) {
            if (a[i]==b[0]){
                ab[i][0] = 1;
                for (int j = i+1; j <n ; j++) {
                    ab[j][0] = 1;
                }
                break;
            }
        }

        //设置第一行
        for (int i = 0; i < m; i++) {
            if (b[i] == a[0]){
                ab[0][i] = 1;
                for (int j = i+1; j <m ; j++) {
                    //如果上面为1了，表示两个字母相同，则下面的数据也为1
                    ab[0][j] = 1;
                }
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]){
                    //如果两个数相等，说明为左上角的数+1
                    ab[i][j] = ab[i-1][j-1]+1;
                }else {
                    //如果不相等，则取左或则上面最大的数
                    ab[i][j] = Math.max(ab[i-1][j],ab[i][j-1]);
                }

            }

        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(ab[i][j]+" ");
            }
            System.out.println();
        }

        return ab[n-1][m-1];
    }


    /**
     * LCS算法
     */
    public static int max(int a,int b){
        return (a>b)?a:b;
    }
    public static void getLCS(String x,String y){
        char[] s1=x.toCharArray();
        char[] s2=y.toCharArray();
        int[][] array=new int[x.length()+1][y.length()+1];
        //先把第一行和第一列填上零
        for (int i = 0; i < array[0].length; i++) {
            array[0][i]=0;
        }
        for (int i = 0; i < array.length; i++) {
            array[i][0]=0;
        }
        //使用动态规划的方式填入数据
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if(s1[i-1]==s2[j-1]){//如果相等，左上角加1填入
                    array[i][j]=array[i-1][j-1]+1;
                }else{
                    array[i][j]=Math.max(array[i-1][j],array[i][j-1]);
                }
            }
        }
        //打印
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

        //从后往前找到结果
        Stack result=new Stack();
        int i=x.length()-1;
        int j=y.length()-1;
        while((i>=0) && (j>=0)){
            if(s1[i]==s2[j]){
                result.push(s1[i]);
                i--;
                j--;
            }else{//注意数组和String中的位置有一位差
                if(array[i+1][j+1-1]>array[i+1-1][j+1]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        System.out.println("-----");
        while(!result.isEmpty()){
            System.out.println(result.pop()+" ");
        }
    }



}
