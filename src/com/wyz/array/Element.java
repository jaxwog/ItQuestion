package com.wyz.array;

/**
 * 稀疏矩阵三元组
 *矩阵中非零元素个数远小于矩阵元素个数，且非零元素分布无规律。
 * 设矩阵  Amxn  中有t个非零元素，称δ=t/(m×n)为矩阵的稀疏因子，通常δ≤0.05的矩阵为稀疏矩阵
 * 三元组：行号row，列号column，值value
 */
public class Element implements Comparable<Element> {
     int row;
     int column;
     int value;

    public Element(int row,int column,int value){
        if (row<0||column<0){
            throw new IllegalArgumentException("稀疏矩阵的行/列号为非正数");
        }
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public Element(){
        this(0,0,0);
    }

    public Element(Element element){
        this(element.row,element.column,element.value);
    }

    @Override
    public String toString() {
        return "("+row+","+column+","+value+")";
    }

    public Element toSymmetry(){
        return new Element(this.column, this.row, this.value);
    }

    public boolean equals(Object obj){
        if (!(obj instanceof Element)){
            return false;
        }
        Element temp = (Element) obj;
        return this.row==temp.row && this.column==temp.column && this.value==temp.value;
    }

    /**
     *
     * @param item   比较三元组对象参数
     * @return    0表示相等
     */
    @Override
    public int compareTo(Element item) {
        if (this.row< item.row || this.row==item.row && this.column<item.column){//当前对象小于传入对象
            return -1;
        }
        if (this.row==item.row && this.column==item.column){      //当前对象与传入对象相等
            return 0;
        }
        return 1;                                              //当前对象大于传入对象
    }
}
