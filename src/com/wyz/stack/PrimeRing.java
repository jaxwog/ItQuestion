package com.wyz.stack;

import com.wyz.linearlist.SeqList;

/**
 * 素数环问题：
 * 一个由自然数 1…n (n < 20)的n个自然数排成一行，要求任意两个相邻数的和为素数（不要求头和尾之和也为素数）
 */
public class PrimeRing {

    public PrimeRing(int n) {
        SeqList<Integer> ring = new SeqList<Integer>(n);     //创建顺序表用来存储素数环(1-n的素数环)
        ring.append(new Integer(1));
        SeqQueue<Integer> que = new SeqQueue<Integer>(n);   //创建一个队列que

        for (int i = 2; i <= n; i++) {                      //从2到n全部入队列
            que.enqueue(new Integer(i));
        }
        System.out.println(que.toString());

        int i = 0;                                   //用来记录顺序表中位置元素
        while (!que.isEmpty()) {
            int k = que.dequeue().intValue();             //出队列，判断出队列的元素与顺序表中最后一个数和是否为素数
            System.out.print("dequeue: " + k + "\t");
            if (isPrime(ring.get(i) + k)) {                //如果为素数，则将队列中k元素加入到顺序表中，顺序表中位置记录++
                i++;
                ring.append(new Integer(k));
            } else {                                          //如果该元素不为素数，则继续添加到队列中进行下次循环使用
                que.enqueue(new Integer(k));
            }
            System.out.println("队列: " + que.toString());

        }

        System.out.println("素数环: " + ring.toString());
    }

    //判断一个数是否为素数
    private boolean isPrime(int k) {
        if (k == 2) {
            return true;
        }
        if (k < 2 || k > 2 && k % 2 == 0) {
            return false;
        }
        int j = (int) Math.sqrt(k);      //返回k的平方跟值
        if (j % 2 == 0) {
            j--;                        //获取测试范围内最大奇数
        }

        while (j > 2 && k % j != 0) {
            j -= 2;
        }
        return j < 2;
    }
}
