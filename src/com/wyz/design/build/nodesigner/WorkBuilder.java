package com.wyz.design.build.nodesigner;

/**
 * com.wyz.design.build.nodesigner
 * Created by jax on 2019/11/15 10:02
 * TODO:创建内部类，只有build时候才把建造房子的数据传入到房子中
 */
public class WorkBuilder {
    private RoomParams mParams;

    public WorkBuilder(){
        mParams = new RoomParams();
    }

    public WorkBuilder makeWindow(String window){
        mParams.window = window;
        return this;
    }

    public WorkBuilder makeFloor(String floor){
        mParams.floor = floor;
        return this;
    }

    public WorkBuilder makeDoor(String door){
        mParams.door = door;
        return this;
    }

    public Room build(){
        Room room = new Room();
        room.apply(mParams);
        return room;
    }




    class RoomParams{
        public String window;
        public String floor;
        public String door;
    }
}
