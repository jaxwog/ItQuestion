package com.wyz.design.build;

/**
 * com.wyz.design.build
 * Created by jax on 2019/11/14 16:18
 * TODO:
 *  * 指导者 角色
 *  * 所具备的能力
 *  *
 *  * 设计师  他知道房子怎么设计
 *  * 他会指挥工人去建造
 *  * 实际生活中  大厦的设计者并不会看大厦的具体实现细节
 *  * 更多的是从整体角度出发，指挥这个工人团队建造
 *  * 所以他肯定对工人所具备的能力和行为有很深的了解
 *  * 换做程序代码中 ，他也肯定会持有工人 的这个对象的引用
 */
public class Designer {

    public void order(IBuild build)
    {
        build.makeFloor();
        build.makeWindow();
    }
}
