package com.wyz.array;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wyz.array
 * Created by jax on 2020/4/20 23:33
 * TODO:
 */
public class TestArray {


    public static void main(String[] args) {
//        int[] table = {3, 1, 5, 8, 2, 9, 4, 6, 7};
        int[] table = {583,8,2,6,10,44,138,28,5,1,0,236};//希尔排序
        System.out.print("原生数组： ");
        print(table);
        //        bubbleSort4(table);
//        selectSort(table);
//        quickSort(table);
//        mergeSort(table,0,table.length-1);
//        insertSort(table);
//        shellSort(table);
//        heapSort(table);
        basicSort(table);
        System.out.print("排序数组： ");
        print(table);
    }

    //基数排序
    public static void basicSort(int []table){
        int maxValue = 0;
        //查找最大值
        for (int i = 0; i < table.length; i++) {
            if (maxValue<table[i]){
                maxValue = table[i];
            }
        }

        //根据最大值，计算出位数
        int times = 0;

        while (maxValue>0){
            maxValue = maxValue/10;
            times++;
        }

        List<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> qTemp = new ArrayList<>();
            queue.add(qTemp);
        }

        //先比较个位，再比较高位
        for (int i = 0; i < times; i++) {

            for (int j = 0; j < table.length; j++) {
                int x = table[j] % (int) Math.pow(10,i+1)/(int)Math.pow(10, i);
                ArrayList<Integer> q = queue.get(x);
                q.add(table[j]);
                queue.set(x,q);
            }

            int count = 0;

            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size()>0){
                    ArrayList<Integer> q = queue.get(j);
                    table[count++] = q.get(0);
                    q.remove(0);
                }
            }


        }



    }

    public static void bubbleSort1(int[] array) {
        int num = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                num++;
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        //64
        System.out.println("一共走了： " + num);
    }

    public static void bubbleSort2(int[] array) {
        int num = 0;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                num++;
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        //36
        System.out.println("一共走了： " + num);
    }

    public static void bubbleSort3(int[] array) {
        int num = 0;
        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                num++;
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        //26
        System.out.println("一共走了： " + num);
    }

    //最优解，exchange不会重复申请空间
    public static void bubbleSort4(int[] table) {
        boolean exchange = true;//是否交换的标记
        int num = 0;
        for (int i = 1; i < table.length && exchange; i++) {
            exchange = false;//假定元素未交换
            for (int j = 0; j < table.length - i; j++) {
                num++;
                if (table[j] > table[j + 1]) {
                    int temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                    exchange = true;//有交换
                }
            }
        }
        //26
        System.out.println("一共走了： " + num);

    }

    //选择排序
    public static void selectSort(int[] table) {
        int min;

        for (int i = 0; i < table.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < table.length; j++) {
                if (table[min] > table[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = table[min];
                table[min] = table[i];
                table[i] = temp;
            }

        }

    }


    //插入排序
    public static void insertSort(int[] table) {
         //{3, 1, 5, 8, 2, 9, 4, 6, 7}
        for (int i = 1; i < table.length; i++) {
            int temp = table[i];
            int j;
            for (j = i-1; j >=0 && temp < table[j] ; j--) {
                table[j+1] = table[j];
            }
            table[j+1] = temp;

        }

    }

    public static void shellSort(int []table){

        for (int i = table.length/2; i > 0 ; i/=2) {

            for (int j = i; j < table.length; j++) {
                int temp = table[j];
                int k;
                for (k = j-i; k >=0 && temp< table[k]; k-=i) {
                    table[k+i] = table[k];
                }
                table[k+i] = temp;
            }
        }
    }

    public static void heapSort(int []table){
        if (table==null || table.length<2) return;
        buildMaxHeap(table);//创建大堆

        for (int i = table.length-1; i>=1; i--) {
            swap(table,0,i);
            maxHeap(table,i,0);
        }



    }

    private static void buildMaxHeap(int[] table) {
        int half = (table.length-1)/2;
        for (int i = half; i >= 0; i--) {
            maxHeap(table,table.length,i);
        }
    }

    private static void maxHeap(int[] table, int length, int index) {
        int largest = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if (left<length && table[left]> table[largest]){
            largest = left;
        }

        if (right<length && table[right]>table[largest]){
            largest = right;
        }

        if (largest!=index){
            swap(table,index,largest);
            maxHeap(table,length,largest);
        }
    }


    //快速排序
    public static void quickSort(int []table){
        if (table.length>1){
            quickSort(table,0,table.length-1);
        }

    }


    //快速排序
    private static void quickSort(int[] table,int low,int hight) {
        if (low<hight) {
            int middle = getMiddle(table, low, hight);
            quickSort(table, 0, middle - 1);
            quickSort(table, middle + 1, hight);
        }
    }

    private static int getMiddle(int[] table, int low, int hight) {
        int temp = table[low];
        while (low<hight){
            while (low < hight && table[hight]>=temp){
                hight--;
            }
            table[low] = table[hight];

            while (low<hight && table[low]<=temp){
                low++;
            }
            table[hight] = table[low];

        }
        table[low] = temp;

        return low;
    }

    public static void mergeSort(int table[],int left,int right){
        if (left==right){
            return;
        }else {
            int middle = (left+right)/2;
            mergeSort(table,left,middle);
            mergeSort(table,middle+1,right);
            merge(table,left,middle,right);
        }
    }


    //合并两个数组
    private static void merge(int[]table,int left,int middle,int right){
        int leftSize = middle-left;
        int rightSize = right-middle+1;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = left; i < middle; i++) {
            leftArray[i-left] = table[i];
        }

        for (int i = middle; i <=right ; i++) {
            rightArray[i-middle] = table[i];
        }

        int i= 0,j = 0,k = left;

        while (i<leftSize && j<rightSize ){
            if (leftArray[i]<rightArray[j]){
                table[k++]=leftArray[i++];
            }else {
                table[k++]=rightArray[j++];
            }
        }

        while (i<leftSize){
            table[k++] = leftArray[i++];
        }

        while (j< rightSize){
            table[k++] = rightArray[j++];
        }

    }

    public static void swap(int table[],int i,int j){
        //判断i、j是否越界
        if (i>=0 && i<table.length && j>=0 && j<table.length && j!=i){
            int temp = table[i];
            table[i] = table[j];
            table[j] = temp;
        }
    }

    public static void print(int[] table) {
        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                System.out.print(" " + table[i]);
            }
        }
        System.out.println();
    }
}
