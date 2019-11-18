package com.wyz.hlm;

/**
 * 发送接收消息
 */
public class Handler {

    //创建Looper获取的
   private MessageQueue mQueue;
   private Looper mLooper;


   //Handler的初始化在主线程中完成，
   public Handler(){
       //获取主线程的Looper对象
       mLooper = Looper.myLooper();
       this.mQueue =mLooper.mQueue;
   }

    /**
     * 发送消息，压入队列
     * @param msg
     */
    public void sendMessage(Message msg){
        msg.target = this;
        mQueue.enqueueMessage(msg);

    }

    /**
     * 子类重载时候进行处理
     * @param msg
     */
    public void handleMessage(Message msg) {
    }

    /**
     * 转发
     * @param msg
     */
    public void dispatchMessage(Message msg) {
            handleMessage(msg);
    }

}
