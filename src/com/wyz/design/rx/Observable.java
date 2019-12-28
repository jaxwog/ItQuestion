package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 11:22
 * TODO: 集市
 * 一个养羊的通过集市换取铁器
 * T 代表打铁
 */
public class Observable<T> {
    //养羊的人
    private OnSubscriable<T> onSubscriable;

    private Observable(OnSubscriable<T> onSubscriable) {
        this.onSubscriable = onSubscriable;
    }

    /**
     * 实例化买卖羊的集市
     *
     * @param onSubscriable
     * @param <T>
     * @return
     */
    public static <T> Observable<T> create(OnSubscriable<T> onSubscriable) {
        return new Observable<>(onSubscriable);
    }

    /**
     * 铁匠来到集市
     * 订阅发布
     * @param subscrible
     */
    public void subscrible(Subscrible<? super T> subscrible) {
        //养羊的   1
        //卖铁的人 2 根据map反悔的类型进行判断
        onSubscriable.call(subscrible);
    }

    /**
     * 实例化 打铁的集市
     * 实现链式调度关键
     * @param func 转换的函数   羊--》铁
     * @param <R>
     * @return
     */
    public <R> Observable<R> map(Func1<? super T, ? extends R> func) {
        //OperatorMap  作为介绍人
        return lift(new OperatorMap<T, R>(func));
    }

    private <R> Observable<R> lift(OperatorMap<T, R> trOperatorMap) {
        //代码运行在这里面的时候 是买羊的集市 onSubscriable表示养羊的人

        //OnSubsricbleLift  作为卖铁的人
        return new Observable<>(new OnSubsricbleLift<>(onSubscriable, trOperatorMap));
    }

    public  Observable<T> subscribleOnIO() {
        return create(new OnSubscribleOnIO<T>(this));
    }
    //切换到主线程先删除，只支持单个线程的切换（都在子线程中执行）
}
