package com.wyz.test;

/**
 * com.wyz.test
 * Created by jax on 2020/3/2 15:49
 * TODO:麻将，点数和类型
 */
public class Mahjong {
    public int suit;//筒，万，索
    public int rank;//点数 一  二  三

    public Mahjong(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "("+this.suit+" "+this.rank+")";
    }
}
