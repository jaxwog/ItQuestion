package com.wyz.array;

/**
 * 矩阵类
 */
public class Matrix {

    private int value[][];

    public Matrix(int m, int n) {
        this.value = new int[m][n];
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(int mat[][]) {
        this(mat.length, mat[0].length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                this.value[i][j] = mat[i][j];
            }
        }
    }

    public int get(int i, int j) {
        return this.value[i][j];
    }

    public void set(int i, int j, int k) {
        this.value[i][j] = k;
    }

    public Matrix add(Matrix a) {
        if (this.value.length == a.value.length && this.value[0].length == a.value[0].length) {
            Matrix c = new Matrix(this.value.length, this.value[0].length);
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    c.value[i][j] = this.value[i][j] + a.value[i][j];
                }
            }
            return c;
        } else {
            return null;
        }

    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                str += "  " + this.value[i][j];
            }
            str += "\n";
        }
        return str;
    }

    //transpose方法中添加代码，求当前矩阵this的转置矩阵
    public Matrix transpose() {
        Matrix c = null;
        //添加代码实现转置。
        return c;
    }

    //multiply方法中添加代码实现矩阵this和矩阵a相乘。结果是矩阵c
    public Matrix multiply(Matrix a) {
        Matrix c = null;
        //添加代码实现相乘。
        return c;
    }

    //isSymmetricMatrix方法中添加代码，判断this是否为对称阵
    public boolean isSymmetricMatrix() {
        boolean b = false;
        //添加代码实现判断。
        return b;
    }

    //isUpperTriangularMatrix方法中添加代码，判断this是否为上三角矩阵
    public boolean isUpperTriangularMatrix() {
        boolean b = false;
        //添加代码实现判断。
        return b;
    }

    //equals方法中添加代码，比较两个矩阵this和a是否相等
    public boolean equals(Matrix a) {
        boolean b = false;
        //添加代码实现判断。
        return b;
    }
}
