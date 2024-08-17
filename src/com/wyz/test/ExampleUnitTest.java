package com.wyz.test;

import java.util.LinkedList;

/**
 * com.wyz.test
 * Created by jax on 2020/3/2 11:00
 * TODO:
 */
public class ExampleUnitTest {
    public static void main(String[] args) {
        testSwap();
        addition_isCorrect();
        int[] table = {3, 1, 5, 8, 2, 9, 4, 6, 7};
        quickSort(table, 0, table.length - 1);


        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + "  ");
        }


    }

    //a和b交换数据
    public static void testSwap() {
        //空间复杂度+时间复杂度+应用场景（重要）
        int a = 5;
        int b = 6;
        //1
//        int t = a; a=b;b =t;

        //2
//        a = a+b; //a=11  ,b = 6
//        b = a-b; //b = 5
//        a = a-b;

        //3 性能最优
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a + "---- b = " + b);
    }

    public static void addition_isCorrect() {
        LinkedList<Mahjong> list = new LinkedList<Mahjong>();
        list.add(new Mahjong(3, 1));
        list.add(new Mahjong(2, 3));
        list.add(new Mahjong(3, 7));
        list.add(new Mahjong(1, 1));
        list.add(new Mahjong(3, 8));
        list.add(new Mahjong(2, 2));
        list.add(new Mahjong(3, 2));
        list.add(new Mahjong(1, 3));
        list.add(new Mahjong(3, 9));
        System.out.println(list);
        radixSort(list);
        System.out.println(list);
    }

    //麻将的排序，或者扑克牌的排序
    private static void radixSort(LinkedList<Mahjong> list) {
        //创建根据点数进行分组，分为9组
        LinkedList[] rankList = new LinkedList[9];
        for (int i = 0; i < rankList.length; i++) {
            rankList[i] = new LinkedList();
        }
        //拿出来每个数据，放到点数里面
        while (list.size() > 0) {
            Mahjong m = list.remove();
            rankList[m.rank - 1].add(m);
        }

        //把9组数据放入到一个链表中
        for (int i = 0; i < rankList.length; i++) {
            list.addAll(rankList[i]);
        }

        //创建根据花色进行分组，分为3组
        LinkedList[] suitList = new LinkedList[3];
        for (int i = 0; i < suitList.length; i++) {
            suitList[i] = new LinkedList();
        }

        //拿出来每个数据，放到花色里面
        while (list.size() > 0) {
            Mahjong m = list.remove();
            suitList[m.suit - 1].add(m);
        }
        //把3组花色放入到一个链表中
        for (int i = 0; i < suitList.length; i++) {
            list.addAll(suitList[i]);
        }

    }


    /**
     * 快速排序     31  21  59  68  12  40
     *
     * @see com.wyz.array.SortedArray
     * @see com.wyz.tree.BinaryTree
     */
    private static void quickSort(int[] array, int begin, int end) {
        if (end - begin <= 0) return;
        int x = array[begin];
        int low = begin;//0
        int high = end;//5
        //由于会从两头取数据，需要一个方向
        boolean direction = true;
        //跳出循环执行L1操作，相当于goto
        L1:
        while (low < high) {
            if (direction) {//从右往左找
                for (int i = high; i > low; i--) {
                    if (array[i] <= x) {
                        array[low++] = array[i];
                        high = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                high = low;//如果上面的if从未进入，让两个指针重合
            } else {
                for (int i = low; i < high; i++) {
                    if (array[i] >= x) {
                        array[high--] = array[i];
                        low = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                low = high;
            }
        }
        //把最后找到的值 放入中间位置
        array[low] = x;
        //开始完成左右两边的操作
        quickSort(array, begin, low - 1);
        quickSort(array, low + 1, end);
    }


}
