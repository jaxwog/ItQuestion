package com.wyz.test;

public class RMBTotial {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private String name = null;
    private int piece = 0;
    private int sum = 0;

    private int totial() {
        return piece * sum;
    }

    @Override
    public String toString() {
        return name + "-" + totial();
    }
}
