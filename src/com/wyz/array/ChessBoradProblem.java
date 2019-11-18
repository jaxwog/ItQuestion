package com.wyz.array;

/**
 * 棋盘问题，分治法，
 * 2的n次方的矩阵中用L行摆放，有特殊点
 * 2 0 3 3
 * 2 2 1 3
 * 4 1 1 5
 * 4 4 5 5
 */
public class ChessBoradProblem {
    private static int[][] board;//棋盘
    private static int specialRow;//特殊点的行下标
    private static int specialCol;//特殊点的列下标
    private static int size ;
    private static int tile=1;///全局变量，表示L型骨牌号
    public static void main(String[] args){
        size = 4;
        specialRow = 0;
        specialCol = 1;
        board = new int[size][size];
        ChessBoradProblem problem = new ChessBoradProblem();
        problem.printBoard(specialRow,specialCol,size);

    }

    /**
     *
     * @param specialRow   特殊点的行下标
     * @param specialCol   特殊点的列下标
     * @param leftRow      矩阵的左边起点行下标
     * @param leftCol      矩阵左边起点的列下标
     * @param size         矩阵的宽或者高
     */
    private void chessBoard(int specialRow,int specialCol,int leftRow,int leftCol,int size){
        if(size == 1){
            return;
        }
        int subSize = size/2;
        int t = tile++; //L型骨牌号

        //假设特殊点在左上角位置
        if (specialRow<leftRow+subSize && specialCol< leftCol+subSize){
            //如果特殊点4x4矩阵在左上角位置，则把左上角2x2矩阵继续迭代
            chessBoard(specialRow, specialCol, leftRow, leftCol, subSize);
        }else {
            //假设4x4矩阵的特殊点不在左上角，则左上角2x2矩阵的右下角就是特殊点
            //设置左上角特殊点内容
            //如果为2x2矩阵，会依次打印出来，不在左上角就打印出左上角
            board[leftRow+subSize-1][leftCol+subSize-1] = t;
            //左上角2x2矩阵的右下角作为特殊点继续迭代2x2的矩阵，在右上方则右上方不进行打印
            chessBoard(leftRow+subSize-1, leftCol+subSize-1, leftRow, leftCol, subSize);
        }

        //特殊点在右上方
        if(specialRow<leftRow+subSize&&specialCol>=leftCol+subSize){
            chessBoard(specialRow, specialCol, leftRow, leftCol+subSize, subSize);
        }else{
            board[leftRow+subSize-1][leftCol+subSize] = t;
            chessBoard(leftRow+subSize-1, leftCol+subSize, leftRow, leftCol+subSize, subSize);
        }
        //特殊点在左下方
        if(specialRow>=leftRow+subSize&&specialCol<leftCol+subSize){
            chessBoard(specialRow, specialCol, leftRow+subSize, leftCol, subSize);
        }else{
            board[leftRow+subSize][leftCol+subSize-1] = t;
            chessBoard(leftRow+subSize, leftCol+subSize-1, leftRow+subSize, leftCol, subSize);
        }

        //特殊点在右下角
        if(specialRow>=leftRow+subSize&&specialCol>=leftCol+subSize){
            chessBoard(specialRow, specialCol, leftRow+subSize, leftCol+subSize, subSize);
        }else{
            board[leftRow+subSize][leftCol+subSize] = t;
            chessBoard(leftRow+subSize, leftCol+subSize, leftRow+subSize, leftCol+subSize, subSize);
        }

    }

    public void printBoard(int specialRow,int specialCol,int size){
        chessBoard(specialRow, specialCol, 0, 0, size);
        printResult();
    }

    private void printResult() {
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
