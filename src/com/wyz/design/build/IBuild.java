package com.wyz.design.build;

/**
 * com.wyz.design.build
 * Created by jax on 2019/11/14 16:12
 * TODO:
 *  * 建造者角色
 *  * 工人接口，定义了各个工人所需要进行的工作
 *  * 并不负责具体的建造
 *  * 同时房子是具体的（农民工）建造的  所以需要有返回房子的方法
 */
public interface IBuild {
    public void makeWindow();

    public void  makeFloor();

    public Room getRoom();

}
