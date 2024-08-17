package com.wyz.hlm;

/**
 * com.wyz.hlm
 * Created by jax on 2020/6/21 23:32
 * TODO:
 */
public class TestThreadLocals {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

            @Override
            protected String initialValue() {
                return "我是重写的";
            }
        };

        System.out.println(Thread.currentThread() + ", " + threadLocal.get());
        int SYSPROPS_TRANSACTION = ('_' << 24) | ('S' << 16) | ('P' << 8) | 'R';
        System.out.println(", " + SYSPROPS_TRANSACTION);
        final int BIND_AUTO_CREATE = 0x0001;
        System.out.println("," + (BIND_AUTO_CREATE & BIND_AUTO_CREATE));
        //---------------------------------------------------thread-1

        new Thread(new Runnable() {
            @Override
            public void run() {
                //从ThreadLocalMap key=thread-1得值 ？ 没有  就走初始化方法
                String value1 = threadLocal.get();
                System.out.println(Thread.currentThread() + "，" + value1);  //我是重写的

                threadLocal.set("我是线程1");

                System.out.println(Thread.currentThread() + "，" + threadLocal.get());

                //避免大量无意义得内存占用
                threadLocal.remove();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                //从ThreadLocalMap key=thread-1得值 ？ 没有  就走初始化方法
                String value2 = threadLocal.get();
                System.out.println(Thread.currentThread() + "，" + value2);  //我是重写的

                threadLocal.set("我是线程2");

                System.out.println(Thread.currentThread() + "，" + threadLocal.get());

                //避免大量无意义得内存占用
                threadLocal.remove();
            }
        }).start();

        System.out.println(Thread.currentThread() + ", " + threadLocal.get());

    }

}
