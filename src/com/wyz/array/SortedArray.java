package com.wyz.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序算法
 * 排序以关键字为基准进行的
 * 时间复杂度，空间复杂度，算法本身复杂度
 * 基本操作：
 * a.比较两个关键字的大小   table[i] ? table[j]
 * b.将记录从一个位置挪动到另一个位置（移动、交换）
 * public static void swap(int table[],int i,int j){
 * int temp;temp = table[i];table[i] = table[j];table[j] = temp;
 * }
 * 排序算法稳定性：
 * 存在多个关键字相同的记录，经过排序后这些具有相同关键字的记录之间的相对次序保持不变，该算法稳定
 * 内排序和外排序：
 * 排序过程中若整个数据序列都是放在内存中处理（排序时不涉及数据的内、外内存交换），称为内部排序（适用于个数不多的小文件）；
 * 内排序按照策略分类：
 * 插入排序：直接插入排序、折半插入排序、希尔排序（不稳定）
 * 交换排序：冒泡排序、快速排序
 * 选择排序：直接选择排序、堆排序
 * 归并排序
 * 基数排序
 */
public class SortedArray {

    public static void main(String[] args) {
//        int[] table = {27,38,65,97,76,13,27,49,55,4};
        int[] table = {3, 1, 5, 8, 2, 9, 4, 6, 7};
        System.out.print("原生数组： ");
        print(table);
//        bubbleSort(table);//冒泡排序
//        selectSort(table);//选择排序
//        insertSort(table);//直接插入排序
//        binaryInsertSort(table);//二分法插入排序
        shellSort(table);//希尔排序
//         heapSort(table);//堆排序
//        quickSort(table);//快速排序
//         mergeSort(table);//归并排序
//          basicSort(table);//基数排序
    }


    /**
     * 1、冒泡排序，相邻的两个元素进行比较，如果前面大于后面就进行交换
     * 加入标记位，如果没有交换说明顺序已经排好，后面的循环就没必要执行了
     * 5个以下是最优的算法（个位数最好），大概10次左右全部排好
     */
    public static void bubbleSort(int[] table) {
        System.out.println("==========冒泡排序======");
        boolean exchange = true;//是否交换的标记
        for (int i = 1; i < table.length && exchange; i++) {
            exchange = false;//假定元素未交换
            for (int j = 0; j < table.length - i; j++) {
                if (table[j] > table[j + 1]) {
                    int temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                    exchange = true;//有交换
                }
            }
            System.out.print("\n第" + i + "趟: ");
            print(table);
        }
        System.out.print("\n冒泡完成：");
        print(table);

    }


    /**
     * 2、直接选择排序，每次找到剩余中最小的数据排到最前面
     * 比冒泡排序稍微优化点，时间复杂度n^2相同 ，但是这个系数为1/2,
     */
    public static void selectSort(int[] table) {
        System.out.println("==========直接选择排序======");

        for (int i = 0; i < table.length - 1; i++) {
            int min = i;//设第i个数据元素最小
            for (int j = i + 1; j < table.length; j++) {
                if (table[j] < table[min]) {
                    min = j;//记住最小元素下标
                }
            }
            //如果是最小的不用进行交换,减少了交换次数
            if (min != i) {
                int temp = table[i];
                table[i] = table[min];
                table[min] = temp;
            }
            System.out.print("\n第" + (i + 1) + "趟: ");
            print(table);
        }
        System.out.print("\n直接排序完成：");
        print(table);

    }

    /**
     * 3、直接插入排序,拿到后面的数据依次插入到前面已经排好的序列中
     * 数组是引用类型，作为方法的参数，其元素值将被改变
     * 时间复杂的O(n)~O(n*n)之间，初始排列越接近有序，时间效率越高
     * 空间复杂度为O(1)
     * 算法是稳定的
     */
    public static void insertSort(int[] table) {
        System.out.println("==========直接插入排序======");
        //从1开始表示如果只有一个元素不用进行排序，大于两个元素的才比较
        for (int i = 1; i < table.length; i++) {
            int temp = table[i];//每趟将table[i]插入到前面排序序列中
            int j;
            //将前面较大元素向后移动,从最近的（已经排好序列的最右边）开始
            for (j = i - 1; j >= 0 && temp < table[j]; j--) {
                table[j + 1] = table[j];
            }
            table[j + 1] = temp; //temp值到达插入位置
            System.out.print("\n第" + i + "趟: ");
            print(table);
        }
        System.out.print("\n直接插入排序完成：");
        print(table);
    }


    /**
     * 4、二分法插入排序
     * 相对于直接插入排序，时间复杂度优化在查找要插入的位置
     * 以左下标为标准，找到要插入位置，然后
     */
    public static void binaryInsertSort(int[] table) {
        System.out.println("==========二分法插入排序======");
        for (int i = 1; i < table.length; i++) {
            int temp = table[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            //确定要插入的位置
            while (left <= right) {
                //获取中间位置
                mid = (left + right) / 2;
                if (temp < table[mid]) {
                    right = mid - 1;//如果值比中间值小，让right左移到中间下标-1
                } else {
                    left = mid + 1;//如果值比中间值大,让left右移到中间下标+1
                }
            }
            //下面与直接插入排序相同
            for (int j = i - 1; j >= left; j--) {
                table[j + 1] = table[j]; //以左下标为标准，在左位置前插入该数据，左及左后边全部后移
            }
            if (left != i) {
                table[left] = temp;//左位置插入该数据
            }
            System.out.print("\n第" + i + "趟: ");
            print(table);
        }
        System.out.print("\n二分法插入排序：");
        print(table);

    }


    /**
     * 5、希尔排序，不稳定排序
     * 一趟分若干组，每组进行直接插入排序
     */
    public static void shellSort(int[] table) {
        System.out.println("==========希尔排序======");
        int k = 0;
        for (int delta = table.length / 2; delta > 0; delta /= 2) {  //若干趟扫描，控制增量delta，增量减半，初始值为长度的一半
            System.out.print("\ndelta=" + delta + "  \n");

            for (int i = delta; i < table.length; i++) {
                int temp = table[i];
                int j;
                for (j = i - delta; j >= 0 && temp < table[j]; j -= delta) { //每组元素相距delta远，寻找插入位置
                    table[j + delta] = table[j];
                }
                table[j + delta] = temp;//插入元素
                print(table);
            }

            System.out.print("\n第" + (++k) + "趟: ");
            print(table);


        }

    }

    public static void shellSort2(int[] table) {
        int d = table.length;//默认增量

        while (true) {
            d = d / 2;
            //最外层循环次数d/2 ,d/4, d/8... 1
            for (int i = 0; i < d; i++) {
                //相邻d位置进行数据的
                for (int j = i; j + d < table.length; j += d) {
                    for (int n = i; n + d < table.length; n += d) {
                        int tmp;
                        if (table[n] > table[n + d]) {
                            tmp = table[n];
                            table[n] = table[n + d];
                            table[n + d] = tmp;
                        }
                    }

                }
            }

            if (d == 1) {
                break;
            }

        }
        print(table);
    }


    /**
     * 6、堆排序
     * 首先建立最大堆（父结点大于子结点，根节点就位最大数,只需要遍历一半的数据）
     * 最大堆对应到数组中的位置关系：
     * left = 2*i+1;(i表示父结点在数组中的位置)
     * right = 2*i+2;
     * 时间复杂度：nlogn（n表示元素个数） ，稳定排序，每次调整的层级为logn
     */
    public static void heapSort(int[] table) {
        if (table == null && table.length <= 1) {
            return;
        }
        System.out.println("==========堆排序======");
        buildMaxHeap(table);//建立最大堆
        int k = 0;
        for (int i = table.length - 1; i >= 1; i--) {
            //最大的在0位置，那么开始沉降，这样每交换一次最大的值就丢到最后了
            swap(table, 0, i);
            System.out.print("\n第" + (++k) + "趟: ");
            print(table);
            //继续获取0位置最大值
            maxHeap(table, i, 0);
        }
        System.out.print("\n堆排序：");
        print(table);


    }

    private static void buildMaxHeap(int[] table) {
        int half = (table.length - 1) / 2;
        //最大堆从后向前进行创建（防止叶子节点影响根节点的数据）
        for (int i = half; i >= 0; i--) {
            maxHeap(table, table.length, i);
        }
    }

    /**
     * 一维数组生成最大堆
     *
     * @param table    数组数据（可能与数组大小不一致）
     * @param heapSize 生成最大堆的大小（不用table.size是因为后面已经排好序了，只需要执行前面的长度数据）
     * @param index    要开始生成最大堆的位置（为0表示）从根节点开始生成最大堆
     */
    private static void maxHeap(int[] table, int heapSize, int index) {
        int left = 2 * index + 1;//左子结点位置
        int right = 2 * index + 2;//右子结点位置
        int largest = index; //记录根节点的位置，如果为index表示不动，如果变了表示需要调整树节点的结构

        //数组不越界，并且左子结点大于根节点，赋值给largest
        if (left < heapSize && table[left] > table[index]) {
            largest = left;
        }
        //数组不越界，并且右子结点大于根节点（跟结点可能为left已经赋值，直接采用largest），赋值给largest
        if (right < heapSize && table[right] > table[largest]) {
            largest = right;
        }
        //如果不相等表示有子节点大于根节点
        if (index != largest) {
            swap(table, index, largest);//交换位置
            maxHeap(table, heapSize, largest);//递归调用，计算变动的子节点
        }

    }

    /**
     * 7、快速排序,不稳定排序nlogn
     * 以一个数为基准，找到它的位置（然后再递归方法调用找到每个位置）
     */
    public static void quickSort(int[] table) {
        if (table.length > 1) {
            quickSort(table, 0, table.length - 1);
            print(table);
        }

    }

    private static void quickSort(int[] table, int low, int hight) {
        if (low < hight) {
            int middle = getMiddle(table, low, hight);
            quickSort(table, 0, middle - 1);
            quickSort(table, middle + 1, hight);
        }
    }

    /**
     * 找到该数组中下标为low的基准所在的正确位置
     *
     * @param table 数组
     * @param low   左下标
     * @param hight 右下标
     * @return
     */
    private static int getMiddle(int[] table, int low, int hight) {
        int temp = table[low];//基准
        //当找到了low=hight表示已经找到了该位置
        while (low < hight) {
            //左边下标小于右边下标并且该位置的元素大于基准值，hight--
            //如果碰见了一个小于基准值得数据，那么跳出了该循环（则把low的位置赋值为当前小于基准的值）
            while (low < hight && table[hight] >= temp) {
                hight--;
            }
            //此时上面while循环已经停止，说明改hight下标位置的数据小于基准值
            table[low] = table[hight];

            //左边下标小于右边下标并且该位置的元素小于基准值，low++
            //如果碰见一个大于基准值数据，那么跳出循环（则把high的位置赋值为当前low位置大于基准的值）
            while (low < hight && table[low] <= temp) {
                low++;
            }
            table[hight] = table[low];
        }
        table[low] = temp;//插入到排序后正确的位置
        return low;
    }


    /**
     * 8、归并排序 把数组分层若干份，然后每份进行排序，然后再进行合并
     */
    public static void mergeSort(int[] table) {
        System.out.println("==========归并排序======");
        mergeSort(table, 0, table.length - 1);
        System.out.println("==========归并排序完成======");
        print(table);
    }

    private static void mergeSort(int[] table, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(table, left, middle);
            mergeSort(table, middle + 1, right);
            //执行归并排序
            merge(table, left, middle, right);//合并
        }
    }

    //合并两个数组
    private static void merge(int[] table, int left, int middle, int right) {
        System.out.println("left = " + left + " ,right = " + right + " ,middle = " + middle);
        int[] tempArray = new int[table.length];
        int rightStart = middle + 1;//右边数组的起始位置
        int temp = left;//新数组拷贝到table中使用
        int third = left;//两个数组合并到新数组中的下标

        //比较两个小数组相应下标位置的数组大小，小的先放进新数组
        while (left <= middle && rightStart <= right) {
            if (table[left] < table[rightStart]) {
                tempArray[third++] = table[left++];
            } else {
                tempArray[third++] = table[rightStart++];
            }
        }
        //如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
        while (left <= middle) {
            tempArray[third++] = table[left++];
        }
        //如果右边还有数据......
        while (rightStart <= right) {
            tempArray[third++] = table[rightStart++];
        }

        while (temp <= right) {
            table[temp] = tempArray[temp++];
        }
        print(table);

    }


    /**
     * 9、基数排序， 适用于整数比较
     * 采用二维数组方式，先比较个位按照个位大小排列，然后收集，依次类推；
     * 获取位数最大的值的位数
     */
    public static void basicSort(int[] table) {
        System.out.println("==========基数排序======");
        int maxValue = 0;//获取需要排序中的最大值
        for (int i = 0; i < table.length; i++) {
            if (maxValue < table[i]) {
                maxValue = table[i];
            }
        }

        int times = 0;//获取最大值的位数

        while (maxValue > 0) {
            maxValue = maxValue / 10;
            times++;
        }

        //创建二维数组用来存放已经摆好的位置信息，长度为10，表示从0-9，
        // 子表中存放了全部当前位都为0的数据
        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> q = new ArrayList<>();
            queue.add(q);
        }

        //先比较个位，再比较十位，依次类推
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < table.length; j++) {
                //获取对应的位的值（i为0是各位，1是10位，2是百位）
                // % 表示获取余数（去掉了前面的高位）， / 获取当前位的数据（去掉了后面的地位）
                int x = table[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> q = queue.get(x);
                q.add(table[j]);
                //一位数组可以直接更改，二维数组为引用类型，所以需要设置
                queue.set(x, q);
            }

            //开始收集数据
            int count = 0;

            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> q = queue.get(j);//拿到每一个数组
                    table[count++] = q.get(0);
                    q.remove(0);
                }
            }

            print(table);

        }
        System.out.println("==========基数排序完成======");
        print(table);


    }


    public static void print(int[] table) {
        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                System.out.print(" " + table[i]);
            }
        }
        System.out.println();
    }

    //交换数组中下标为i、j的元素
    public static void swap(int table[], int i, int j) {
        //判断i、j是否越界
        if (i >= 0 && i < table.length && j >= 0 && j < table.length && j != i) {
            int temp = table[i];
            table[i] = table[j];
            table[j] = temp;
        }
    }


}
