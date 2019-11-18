package com.wyz.array;

/**
 *下三角矩阵线性压缩存储
 */
public class DownTriangleMatrix {

    private int rows;    //下三角矩阵行数（阶数）
    private int element[];  //存储矩阵元素的一维数组

    /**
     *
     * @param rows  阶数
     */
    public DownTriangleMatrix(int rows){
        if (rows<=0){
            throw new IllegalArgumentException("矩阵阶数为非正数"+rows);
        }
        this.rows = rows;
        this.element = new int[rows*(rows+1)/2];
    }

    /**
     *
     * @param rows 阶数
     * @param mat  初始值
     */
    public DownTriangleMatrix(int rows,int mat[]){
        this(rows);
       int n =  this.element.length<=mat.length ? element.length : mat.length;
        for (int i = 0; i < n; i++) {
            this.element[i] = mat[i];     //mat元素不足时补0，忽略多余元素
        }
    }

    public int get(int i,int j){
        if (i<0||i>=rows||j<0||j>=rows){
            throw  new IndexOutOfBoundsException("矩阵元素的行或者列号越界");
        }
        return i<j ? 0 : element[i*(i+1)/2+j];
    }

    public void set(int i,int j,int value){
        if (i<0||i>=rows||j<0||j>=rows){
            throw  new IndexOutOfBoundsException("矩阵元素的行或者列号越界");
        }
        this.element[i*(i+1)/2+j] = value;
    }

    @Override
    public String toString() {
        String str = "下三角矩阵"+this.getClass().getName()+" ("+this.rows+"阶）:\n";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.rows; j++) {
                str += String.format("%4d",this.get(i,j));
            }
            str +="\n";
        }
        return str;
    }

    public void add(DownTriangleMatrix mat){
        if (this.rows!= mat.rows){
            throw new IllegalArgumentException("两个矩阵阶数不同，不能相加");
        }
        for (int i = 0; i < this.element.length; i++) {
            this.element[i] += mat.element[i];
        }
    }
}
