package com.wyz.hlm;

/**
 * 在主线程（相对启动线程来讲）中开启
 * 主线程至少有一个Looper对象，包含MessageQueue
 */
public final class Looper {

    //looper保存在ThreadLocal中，保证了线程数据的隔离性
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    //一个Looper对应一个MessageQueue
   MessageQueue mQueue;

   private Looper(){
       mQueue = new MessageQueue();
   }

    /**
     * Looper对象初始化
     */
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    /**
     * 获取当前线程的Looper对象
     * @return
     */
    public static  Looper myLooper() {
        return sThreadLocal.get();
    }

    public static void loop(){
        Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }

        MessageQueue queue = me.mQueue;
        for (;;){
            Message msg = queue.next();
            if (msg == null){
                continue;
            }
            //转发给Handler

            msg.target.dispatchMessage(msg);


        }

    }




}
