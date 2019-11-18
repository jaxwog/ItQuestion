package com.wyz.j2ee;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;

/**
 * 折半查找
 */
public class ArraySearch implements Comparable<ArraySearch>{



    @Override
    public int compareTo(ArraySearch o) {
        //比较两个对象的大小
        return 0;
    }

    //枚举类型,定义了新的myColor类型
    public enum myColor{
        red,green,black,blue
    }

    public  int startNum,endNum,searchNum;
    public int []a;

    public ArraySearch(int[]a,int searchNum){
        startNum = 0;
        endNum =a.length-1;
        this.searchNum = searchNum;
        this.a = a;
    }

    public  int serach(){
        for (int i = 0; i <= this.endNum; i++) {
            if (a[i]==this.searchNum){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(){
        int b = (startNum+endNum)/2;
        while (startNum<=endNum){
            if (searchNum==a[b]){
                return b;
            }
            if (searchNum>a[b]){
                startNum = b+1;
            }
            if (searchNum<a[b]){
                endNum = b-1;
            }
            b = (startNum+endNum)/2;
        }
        return -1;
    }

    public static double[][] stringToDouble(String s){
        String s1[] = s.split(";");
//        System.out.println(s1.length);
        double[][] d= new double[s1.length][];
        for (int i = 0; i < s1.length; i++) {
          String s2[] =  s1[i].split(",");
//            System.out.println(s2.length);
            d[i] = new double[s2.length];
            for (int j = 0; j < s2.length; j++) {
                d[i][j] = Double.parseDouble(s2[j]);
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }


        return d;
    }

    public static void collect(){
        Collection<String> collection = new HashSet<String>();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        for (Iterator<String> iterator = collection.iterator();iterator.hasNext();){
            String s = iterator.next();
            System.out.println(s);
        }
    }

    public static void enumDir(myColor m){
        switch (m){
            case red:
                System.out.println(m);
                break;
            case blue:
                System.out.println(m);
                break;
            case black:
                System.out.println(m);
                break;
            case green:
                System.out.println(m);
                break;
        }
    }

    public static void findFile(){
       // File file = new File("/Users/wangyongzheng/IDEA/ItQuestion");
        File file = new File("/Users/wangyongzheng/Music");
                System.out.println(file.getName());
        fileList(file, 1);
    }

    public static void fileList(File f,int leve){
        File[] files = f.listFiles();
       String fileStr = "";
        for (int i = 0; i < leve; i++) {
            fileStr += "  ";
        }

        for (int i = 0; i < files.length; i++) {
            System.out.println(fileStr+files[i].getName());
            if (files[i].isDirectory()){
                fileList(files[i],leve+1);
            }
        }

    }

    public static void fileCreat(){
        String fileName = "myFile.txt";
        String fileDir = "dir1"+ File.separator+"dir2";
        File file = new File(fileDir,fileName);//只是在内存中创建一个对象
        if (file.exists()){
            System.out.println("文件路径"+file.getAbsolutePath());
            System.out.println("文件大小"+file.length());
        }else {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void findAORa(String s){

        int aCount=0;
        int ACount = 0;
        int numCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c>='a' && c<='z'){
               aCount++;
            }else if (c>='A' && c<='Z'){
                ACount++;
            }else {
                numCount++;
            }
        }

        System.out.println("大写字母："+ACount+"个，小写字母："+aCount+",其它："+numCount+"个");

    }



    public static int[] bubbleSort(int[] a){
        int len = a.length;
        for(int i = len-1;i>=1;i--){
            for(int j = 0;j<=i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;
    }

    public static int[] selectionSort(int[] a) {
        for(int i=0; i<a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static int[] insertSort(int[] a) {
        for(int i=1; i<a.length; i++) {
            for(int j=i; j>0; j--) {
                if(a[j] < a[j-1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                } else {
                    break;
                }
            }
        }
        return a;
    }



}
