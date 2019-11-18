package com.wyz.design.instance;

/**
 * com.wyz.design.instance
 * Created by jax on 2019/11/7 17:10
 * TODO:单例模式 内部类加载，比较优雅模式（用到再加载并且线程安全）
 */
public class InnnerClassSingle {
    private InnnerClassSingle() {
    }

    /**
     * 内部类不会编译是就加载到静态区域，只有运行时才会加载
     */
    private static class SingleHodler{
        private static final InnnerClassSingle instance = new InnnerClassSingle();
    }

    public static InnnerClassSingle getInstance() {
        return SingleHodler.instance;
    }

}
