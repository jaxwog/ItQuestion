package com.wyz.design.build;

/**
 * com.wyz.design.build
 * Created by jax on 2019/11/14 16:15
 * TODO:具体建造者,持有房屋的引用
 */
public class WorkBuilder implements IBuild{
    private Room room=new Room();
    @Override
    public void makeWindow() {
        room.setWindow("法式落地窗");
    }

    @Override
    public void makeFloor() {
        room.setFloor("欧式共穹顶");
    }

    @Override
    public Room getRoom() {
        return room;
    }
}
