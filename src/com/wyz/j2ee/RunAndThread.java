package com.wyz.j2ee;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Date;

public class RunAndThread {



    //关于线程调用，启动线程和调用方法区别
    public static void run1(){
        Runnable1 runnable1 = new Runnable1();
        //runnable1.run();//直接调用该类的方法（方法调用）,不会重新启动线程
        runnable1.start();//启动新线程，主线程与子线程同步执行（交替显示输出结果）

        //实现Runnable接口，在主线程中创建Thread对象，传入Runnable接口对象
//        Thread thread = new Thread(runnable1);
//        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread:"+i);
        }
        new Frame("hello").repaint();
    }

    //关于Interrupt使用
    public static void run2(){
        Runnable2 runnable2 = new Runnable2("Runnable2");
        runnable2.start();
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //正在sleep的线程，用interrupt方法，Runnable2线程直接被打断，抛出异常
        //犹如一盆凉水，但是还有抛出异常进行处理，stop犹如一根棒子，不给处理打开内容占用
        runnable2.interrupt();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(runnable2.isAlive());

    }

    //测试join方法
    public static void run3(){
      String s =   Thread.currentThread().getName();//获取当前线程，相当于获取当前对象this
        Runnable3 r3 = new Runnable3("wyzThread");
        r3.start();
       //等待r3线程执行结束(先执行)，再执行主线程其它方法（后执行）
        try {
            r3.join();//相当于方法调用
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("I am "+s+ " Thread");
        }

    }

    //yield先让一下，并不是不执行
    public static void run4(){
        Runnable4 r1 = new Runnable4("wyzThread1");
        Runnable4 r2 = new Runnable4("wyzThread2");
       // r1.setPriority(Thread.NORM_PRIORITY+3);//设置优先级
        r1.start();
        r2.start();
    }

    //两个线程访问同一个对象
    public static void runSync(){
        TestSync sync = new TestSync();
        Thread t1 = new Thread(sync);
        Thread t2 = new Thread(sync);
        t1.setName("WLAN");
        t2.setName("4G");
        t1.start();
        t2.start();
    }

    public static void runDeahLock(){
        DeahLock deahLock1 = new DeahLock();
        DeahLock deahLock2 = new DeahLock();
        deahLock1.flag = 0;
        deahLock2.flag = 1;
        Thread t1 = new Thread(deahLock1);
        Thread t2 = new Thread(deahLock2);
        t1.start();
        t2.start();
    }

    public static void runTTSync(){
        TTSync ttSync  = new TTSync();
        Thread thread = new Thread(ttSync);
        thread.start();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ttSync.m2();
        System.out.println(ttSync.b);
    }

}

//=========================================================================================================

//class Runnable1 implements Runnable{
    class Runnable1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Runnable1:"+i);
            }
        }
    }


    class Runnable2 extends Thread{

    public Runnable2(String s){
        super(s);
    }

        @Override
        public void run() {
        boolean flag = true;
           while (flag){
               System.out.println(getName()+"="+getPriority()+"======"+ new Date() + "========");
               try {
                   sleep(1000);
               } catch (InterruptedException e) {
                   flag = false;
//                   e.printStackTrace();
               }
           }
        }
    }

    class Runnable3 extends Thread{
        public Runnable3(String s){
            super(s);
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("I am is "+getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    class Runnable4 extends Thread{
        public Runnable4(String s){
            super(s);
        }

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                System.out.println(getName()+": "+i);
                if (i%10==0){
                    yield();
                }
            }
        }
    }


    //=============================线程同步=================================================

   class TestSync implements Runnable{
    Timer timer = new Timer();

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}



class Timer{
    private static int num = 0;
    //public synchronized void add(String name) {
    public void add(String name) {
        synchronized (this) {//锁定当前对象，该线程执行完该方法后才能交给别的线程执行
            num++;
            try {
                Thread.sleep(1);//sleep时候该锁仍然不放
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ", 你是第" + num + "个访问该方法的人");
        }
    }
}

//=============================线程死锁=================================================

class DeahLock implements Runnable{
     int flag = 0;
    static Object o1 = new Object();
    static Object o2 = new Object();

           @Override
           public void run() {
               //防止死锁：增加锁的粒度
             System.out.println("flag = "+flag);
             if (flag==0){
                 //锁住o1对象，然后方法中再锁住o2对象
                 synchronized (o1){
                     try {
                         Thread.sleep(500);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     synchronized (o2){
                         System.out.println("flag=0,方法执行完成");
                     }
                 }

             }

             if (flag==1){
                 synchronized (o2){
                     try {
                         Thread.sleep(500);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     synchronized (o1){
                         System.out.println("flag=1,方法执行完成");
                     }
                 }

             }

           }


}



//锁住了m1方法，但是另一个线程可以访问m2方法，m2方法没有进行锁，所以可以更改参数b，
class TTSync implements Runnable{
    int b =100;
    public synchronized void m1(){
        b=1000;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1()中，b = "+b);
    }
    public synchronized void m2(){
   // public  void m2(){
        b =2000;
        System.out.println("m2()中，b = "+b);
    }

    @Override
    public void run() {
        m1();
    }
}