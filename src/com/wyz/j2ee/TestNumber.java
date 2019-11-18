package com.wyz.j2ee;

public class TestNumber {

    double x;
    double y;
    double z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }



    public TestNumber(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z= z;
//        BB bb = new BB();
//        bb.f();

        DataCom10 [] data = new DataCom10[]{new DataCom10(2004,5,4),
                new DataCom10(2011,7,4),
            new DataCom10(2006,5,4),
            new DataCom10(2008,1,5),
            new DataCom10(2004,2,1)};
            data =   bulbleSort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }

    }

    public  DataCom10[] bulbleSort(DataCom10[] a){
        DataCom10 temp ;
        for (int i = a.length-1; i >=1 ; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (a[j].compare(a[j+1])>0){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

        }
        return a;
    }

    public double pointLine(TestNumber p){
      return   (x-p.x) * (x-p.x) + (y-p.y) * (y-p.y) +(z-p.z) * (z-p.z);
    }

    //阶乘
    public static int methed(int n){
      if (n==1){
          return 1;
      } else {
          return n * methed(n-1);
      }
    }


    //迭代斐波那契数列
    public static long fabFor(int index){

        if (index==1||index==2){
            return 1L;
        }
        long temp = 0L;
        long f1 = 1L;
        long f2 = 1L;
        for (int i = 0; i < index-2; i++) {
            temp = f1+f2;
            f1 = f2;
            f2 = temp;
        }

        return temp;
    }

    //斐波那契数列递归方法调用
    public static long fab(int n){
        if (n==1||n==2){
            return 1L;
        }else {
            return fab(n-1)+fab(n-2);
        }

    }

    //输出101到200间的质数
    public static void numberAnd10(){
        int i = 101;
        while (i<200){
            for (int j = 2; j<i ; j++) {
                if (i%j==0){
                    break;
                }
            }
            System.out.print(i+"  ");

            i+=2;

        }
    }

    //输出101到200间的质数
    public static void numberAnd11(){
        for (int i = 101; i <200 ; i+=2) {
            boolean flag = true;
            for (int j = 2; j <i ; j++) {
                if (i%j==0){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                continue;
            }
            System.out.print(i+"  ");


        }
    }

    //1-100前5个可以被3整除的数
    public static void numberAnd30(){
        int num = 0;
        for (int i = 1; i <= 100; i++) {

            if (i%3==0){
                System.out.print(i+"  ");
                num++;
            }
            if (num==5){
                break;
            }

        }
    }
    //1-100前5个可以被3整除的数
    public static void numberAnd31(){
        int num = 0;
        int i = 1;
        while (i<=100){
            if (i%3==0){
                System.out.print(i+"  ");
                num++;
            }
            if (num==5){
                break;
            }

            i++;

        }
    }


    public static void sortArray10(int []a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }

    public static void sortArray11(int []a){
        int temp ,k;
        for (int i = 0; i < a.length; i++) {
            k = i;
            for (int j = k+1; j < a.length; j++) {
                if (a[k]>a[j]){
                   k = j;
                }

            }
            if (k!=i){
                temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }


}


//继承中的构造方法
    class A{
    A(){
        print("A()");
    }

    protected void print(String s ){
        System.out.println(s);
    }

    public void f(){
        print("A:f()");
    }
}

class BB extends A{
    BB(){
      print("B()");

    }

    @Override
    public void f() {
        print("B:f()");
    }
}


class DataCom10 {
    int year, month,day;
    public DataCom10(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    //比较日期大小，如果当前对象大于形参对象返回1，相等返回0，小于返回-1
    public int compare(DataCom10 data){
       return this.year > data.year ? 1 :
               this.year< data.year ? -1:
               this.month>data.month?1:
               this.month<data.month?-1:
               this.day>data.day?1:
               this.day<data.day?-1:0;

    }

    @Override
    public String toString() {
        return year+"-"+month+"-"+day+"\n";
    }
}
