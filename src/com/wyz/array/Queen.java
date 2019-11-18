package com.wyz.array;

/**
 * 八皇后，回溯法
 * 棋盘中摆放8个，横、竖、正斜、反斜都没有相同的棋子
 * 0  +  +  +  +  +  +  +
 * +  +  +  +  +  +  0  +
 * +  +  +  +  0  +  +  +
 * +  +  +  +  +  +  +  0
 * +  0  +  +  +  +  +  +
 * +  +  +  0  +  +  +  +
 * +  +  +  +  +  0  +  +
 * +  +  0  +  +  +  +  +
 */
public class Queen {
    public static int num = 0;//记录有多少种方法
    public static final int MAXQUEEN = 8;//棋盘大小
    public static int[]cols = new int[MAXQUEEN]; //定义cols数组，表示8列棋子皇后摆放的位置

    public static void main(String[] args){
        Queen queen = new Queen();
        queen.getCount(0);
    }


    /**
     * @param n 填第n列的皇后
     */
    public void getCount(int n){
        boolean []rows = new boolean[MAXQUEEN];//记录每列每个方格是否可以摆放，true表示已经放过了
        for (int m = 0; m < n; m++) {
            //把n前面的都摆放上棋子，cols[m]获取当前m列在棋盘中摆放的位置
            rows[cols[m]] = true;
            int d = n - m;//斜对角（列的差距），摆放位置n的坐标-m位置的坐标 = 计算出距离要摆放位置到m皇后位置的距离
            //正斜方向/，cols[m]皇后所在的位置-差距d ，如果距离》=0表示在对角线上
            if (cols[m]-d>=0){//在棋盘范围内
                //在正斜对角线上，所以置为true
                rows[cols[m] -d] = true;
            }
            //反斜方向\
            if (cols[m]+d<=(MAXQUEEN-1)){
                rows[cols[m]+d] = true;
            }

        }

        //到此知道了哪些位置不能放皇后
        for (int i = 0; i < MAXQUEEN; i++) {
            if (rows[i]){
                continue;
            }
            cols[n] = i;//采用for循环递归，进行回溯
            if (n < MAXQUEEN-1){
                getCount(n+1);
            }else {
                //找到完整的一套方案
                num++;
                printQueen();
            }

        }


    }

    private void printQueen() {
        System.out.println("第"+num+"种方案");
        for(int i = 0;i<MAXQUEEN;i++){
            for(int j = 0;j<MAXQUEEN;j++){
                if(i == cols[j]){
                    System.out.print("0  ");
                }else{
                    System.out.print("+  ");
                }
            }
            System.out.println();
        }
    }



}
