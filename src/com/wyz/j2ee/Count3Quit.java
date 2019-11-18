package com.wyz.j2ee;


public class Count3Quit {
    boolean []arr;
    int arrayLength;

    public Count3Quit(boolean  []array){
        this.arr = array;
        this.arrayLength = array.length;
    }

    int count = 0; //记录为第3的数

    int index = 0;//记录数组下标

   public  void quit(){
        while (arrayLength>1){

            if (arr[index]==true){
                count++;
                if (count==3){
                    arr[index] = false;
                    arrayLength--;
                    count = 0;
                }
            }

            index++;

            if (index== arr.length){
                index = 0;
            }

        }
       for (int i = 0; i < arr.length; i++) {
           if (arr[i]==true){
               System.out.print("我是第"+(i+1)+"个数");
           }
       }

    }







}
