package com.wyz.array;

import java.util.Arrays;

/**
 * 贪心算法，背包放东西，求价值最大
 * 先求出每件的性价比，性价比最大的放入背包，依次放入
 */
public class GreedyPackage {

    private static int MAX_WEIGHT = 150;//最大承重
    private static int[] weights = new int[]{35, 30, 60, 50, 40, 10, 25};//每个物品的重量
    private static int[] values = new int[]{10, 40, 30, 50, 35, 40, 30};//每个物品的价值


    private static void packageGreedy(int capacity, int weights[], int[] values) {
        int n = weights.length;
        double[] r = new double[n];//性价比数组
        int[] index = new int[n];//按性价比排序物品的下标
        for (int i = 0; i < n; i++) {
            r[i] = (double) values[i] / weights[i];
            index[i] = i;//默认排序
        }

        double temp = 0;//对性价比进行排序,性价比相同，把重量轻的放在前面
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }

        //排序好的重量和价值分别存到数组
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = weights[index[i]];
            v1[i] = values[index[i]];
        }
        System.out.println("排好序的重量：" + Arrays.toString(w1));
        System.out.println("排好序的价值：" + Arrays.toString(v1));

        int[] x = new int[n];
        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            if (w1[i] < capacity) {
                //还可以装得下
                x[i] = 1;//表示该物品被装了
                maxValue += v1[i];
                System.out.println("物品" + w1[i] + "被放进包包");
                capacity = capacity - w1[i];
            }
        }
        System.out.println("总共放下的物品数量：" + Arrays.toString(x));
        System.out.println("最大价值：" + maxValue);

    }

    public static void main(String[] args) {
        packageGreedy(MAX_WEIGHT, weights, values);
    }

}
