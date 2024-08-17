package com.wyz.array;

/**
 * 分治法，切割成小块，递归方法调用然后算出比赛天数
 * n只球队进行循环比赛（s系列小组赛模式），必须比赛n-1场
 * 第一竖列表示球队名称，第一横列表示第n-1天
 */
public class SportsSchedule {

    public void scheduleTable(int[][] table, int n) {
        if (n == 1) {
            table[0][0] = 1;
        } else {
            //填充左上区域矩阵
            int m = n / 2;
            scheduleTable(table, m);

            //填充右上区域
            for (int i = 0; i < m; i++) {
                for (int j = m; j < n; j++) {
                    table[i][j] = table[i][j - m] + m;
                }
            }

            //填充左下区域
            for (int i = m; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    table[i][j] = table[i - m][j] + m;
                }
            }

            //填充右下区域
            for (int i = m; i < n; i++) {
                for (int j = m; j < n; j++) {
                    table[i][j] = table[i - m][j - m];
                }

            }

        }

    }

    public static void main(String[] args) {
        //8只队伍7天比赛完成
        int[][] table = new int[8][8];
        int n = 8;
        SportsSchedule schedule = new SportsSchedule();
        schedule.scheduleTable(table, n);
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
                c++;
                if (c % n == 0) {
                    System.out.println();
                }
            }
        }
    }

}
