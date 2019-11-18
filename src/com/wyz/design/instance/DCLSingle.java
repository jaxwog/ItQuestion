package com.wyz.design.instance;

/**
 * com.wyz.design.instance
 * Created by jax on 2019/11/7 16:02
 * TODO:单例模式 双重检查
 */
public class DCLSingle {
    /**
     * volatile 表示指令集按照顺序执行，jdk 1.5之后加入了指令集乱序进行多线程调用，会造成步骤执行不一致
     * 详细参考
     * @see Client
     */
    private volatile static DCLSingle instance;

    private DCLSingle(){

    }

    public static DCLSingle getInstance(){
        //1.先检查对象是否为空，不为空直接返回（不用双检查的时候直接同步，性能差）
        if (instance==null){
            //线程A、B都来到了这个地方，
            //如果对象为空，锁定方法
            synchronized (DCLSingle.class){
                //2.锁定过方法，再检查对象是否为空（A走到了该地方，B走到了第一步，获取对象锁）
                if (instance==null){
                    instance = new DCLSingle();
                }
            }
            //线程A来到了这个地方，线程B锁定方法地方，然后再去判断是否为空
        }
        return instance;
    }
}
