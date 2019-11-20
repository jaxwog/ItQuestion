package com.wyz.design.template;

/**
 * com.wyz.design.template
 * Created by jax on 2019/11/20 10:12
 * TODO:不同用户根据步骤实现不同功能，游戏玩家
 */
public class LolGame extends AbsGame {
    @Override
    void initialize() {
        System.out.println("初始化英雄联盟");
    }

    @Override
    void startPlay() {
        System.out.println("攻入敌方战场");
    }

    @Override
    void endPlay() {
        System.out.println("每打赢，失败，退出游戏");
    }
}
