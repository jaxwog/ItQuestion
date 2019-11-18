package com.wyz.design.build.nodesigner;

/**
 * com.wyz.design.build.nodesigner
 * Created by jax on 2019/11/15 10:02
 * TODO:
 */
public class Room {
    private String window;
    private String floor;
    private String door;

    public Room apply(WorkBuilder.RoomParams params){
        window = params.window;
        floor = params.floor;
        door = params.door;
        return this;
    }

    @Override
    public String toString() {
        return "Room{" +
                "window='" + window + '\'' +
                ", floor='" + floor + '\'' +
                ", door='" + door + '\'' +
                '}';
    }
}
