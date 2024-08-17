package com.wyz.thread;


import java.util.concurrent.*;

//监听多线程处理结果
public class FutureTest {


    public static void test() {
        Task task = new Task();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(task) {

            //异步任务执行完成，回调
            @Override
            protected void done() {
                try {
                    System.out.println("done:" + get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

        //线程池（使用了预定义的配置）
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(futureTask);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }


//       //取消异步任务
//       futureTask.cancel(true);

        //阻塞，等待异步任务执行完毕
        try {
            //获取异步任务的返回值
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    //异步执行任务
    static class Task implements Callable<Integer> {

        //返回异步任务执行结果
        @Override
        public Integer call() throws Exception {
            int i = 0;
            for (; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "_" + i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return i;
        }
    }
}
