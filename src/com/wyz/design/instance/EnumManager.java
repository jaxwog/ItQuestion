package com.wyz.design.instance;

/**
 * com.wyz.design.instance
 * Created by jax on 2019/11/7 17:21
 * TODO:枚举类型实现单例模式
 */
public enum EnumManager {
    SDCardManager(10) {
        @Override
        public EnumManager getSingle() {
            return SDCardManager;
        }


    },
    HttpManager(1) {
        @Override
        public EnumManager getSingle() {
            return null;
        }
    };

    public SdCardImpl getSingleton() {
        return new SdCardImpl();
    }


    public abstract EnumManager getSingle();

    private EnumManager(int type) {

    }
}