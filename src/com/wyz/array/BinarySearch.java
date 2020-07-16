package com.wyz.array;

/**
 * 二分法查找元素位置
 */
public class BinarySearch {
    private static int count = 1;

    public static void main(String []args){
        int[] table = {27,38,65,97,76,13,27,49,55,4};
//        SortedArray.print(table);
//        SortedArray.basicSort(table);//基数排序
//        binarySearch(49,table,0,table.length-1);

//        directBinarySearch(table,49);

        hanNota(3, 'A', 'B', 'C');

//        int x = gcd(99,55);
//        System.out.println("最大公约数为："+x);
//        long l = calNFact(5);
//        System.out.println("5阶层为："+l);

    }


    //递归方式查找元素
    public static int binarySearch(int elem,int []table,int low,int high){
        if(low>high){
            return -1;
        }

        int middle = (low+high)/2;

        if (table[middle]==elem){
                System.out.println("找到对应元素值，下标为："+middle);
                return middle;
        }

        if (table[middle]>elem){
          return   binarySearch(elem,table,low,middle-1);
        }

        if (table[middle]< elem){
          return   binarySearch(elem,table,middle+1,high);
        }

        return -(low+1);
    }


    //非递归方式二分法查找
    public static int directBinarySearch(int[] table,int elem){
        int low = 0;
        int high = table.length-1;
        while(low<=high){
            int middle = (low+high)/2;
            if(elem>table[middle]){
                //右边找
                low = middle+1;
            }else  if(elem<table[middle]){
                high = middle - 1;
            }else{
                System.out.println("找到相应元素，下标为："+middle);
                return middle;
            }
        }
        return -(low+1);
    }


    /**
     * 汉诺塔递归求转换步骤（3个柱子，大的必须在下面）
     * @param n 一共有多少块
     * @param from 初始放了全部块
     * @param dependOn  借助的柱子
     * @param to  要到达的柱子
     */
    public static void hanNota(int n,char from,char dependOn,char to){

        if (n == 1){
            move(1,from,to);
        }else {
            hanNota(n-1,from,to,dependOn);//第一步，先将n-1个盘子从A利用C挪到B
            move(n,from,to);//讲n这个盘子（底盘最大的）从A挪到C
            hanNota(n-1,dependOn,from,to);//讲n-1个盘子从B利用A挪到C
        }
    }

    private static void move(int n, char from, char to) {
        System.out.print("第"+n+"块从"+from+"------>"+to);
        System.out.println("     ||||||||||||--------第"+count+++"步从"+from+"------>"+to);
    }



    // (m>n)m和n的最大公约数 = n 和m%n的最大公约数
    //默认传入的数据m>n，    欧几里得算法
    public static int gcd(int m,int n){
        if (n==0){
            return m;
        }else {
            return gcd(n,m % n);
        }
    }

    public static long calNFact(int n){
        if (n==1){
            return n;
        }else {
            return n*calNFact(n-1);
        }
    }



}
