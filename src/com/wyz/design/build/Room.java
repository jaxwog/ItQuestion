package com.wyz.design.build;

/**
 * com.wyz.design.build
 * Created by jax on 2019/11/14 16:13
 * TODO:
 *  * 房子类
 *  * 首先要描述下 房子要有些什么
 *  * 有哪些属性
 */
public class Room {
    private String window;
    private String floor;

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "window='" + window + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
