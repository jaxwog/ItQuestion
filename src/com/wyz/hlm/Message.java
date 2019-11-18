package com.wyz.hlm;

/**
 * 消息，包含类型，对象
 */
public class Message {

    public int what;

    public Object obj;

    Handler target;

    @Override
    public String toString() {
        return obj.toString();
    }
}
