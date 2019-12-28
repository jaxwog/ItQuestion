package com.wyz.design.rx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/29 01:49
 * TODO:线程切换中间类
 */
public class OnSubscribleOnIO<T> implements OnSubscriable<T> {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    Observable<T> source;

    public OnSubscribleOnIO(Observable<T> source) {
        this.source = source;
    }

    @Override
    public void call(final Subscrible<? super T> subscrible) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                source.subscrible(subscrible);
            }
        };
        executorService.submit(runnable);
    }
}
