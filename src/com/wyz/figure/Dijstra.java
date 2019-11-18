package com.wyz.figure;

/**
 * 迪杰斯特拉算法，求图中两点之间最短路径，类似于prim算法
 * 该方法求的是V0到各个结点之间的最短路径
 */
public class Dijstra {
    private final static int MAX_VEX = 9;
    private final static int MAX_WEIGHT = 65535;
    private int shortTablePath[] = new int[MAX_VEX];// 记录的是v0到某顶点的最短路径和



    public static void main(String[] args){
        String s = "我爱你中国\"哈哈哈\"";

        System.out.println(s);


        MyFigure graph = new MyFigure(MAX_VEX);
        graph.createGraph();
        Dijstra dijstra = new Dijstra();
        dijstra.shortestPathDijstra(graph);
    }

    private void shortestPathDijstra(MyFigure graph) {
        int min;//记录查询出来最小值
        int k = 0;// 记录下标，用来查询矩阵中的行中的数据
        boolean isgetPath[] = new boolean[MAX_VEX];//初始化数据，都为false；找到最小值后置为true

        for (int v = 0; v < graph.getVertexSize(); v++) {
            shortTablePath[v] = graph.getMatrix()[0][v];// 获取v0这一行的权值数组
            //shortTablePath = {0,1,5,max,max,max,max,max,max}
        }

        //第一个V0位置表示为0，V0--->V0,V0置为true
        shortTablePath[0] = 0;
        isgetPath[0] = true;

        for (int i = 1; i < graph.getVertexSize(); i++) {
            min = MAX_WEIGHT;

            //找出shortTablePath中最小的值并且没有找到的数据
            //获取有交点的顶点的下标
            for (int j = 0; j < graph.getVertexSize(); j++) {
                if (!isgetPath[j] && shortTablePath[j]<min){
                    min = shortTablePath[j];//找到最小的值
                    k = j;//最小值的位置
                }
            }

            //最小值的位置变更为true
            isgetPath[k] = true;

            //遍历第K行
            for (int j = 0; j < graph.getVertexSize(); j++) {
                //当该位置没有找到最小值，并且最小值+该行的权值如果小于存储最短路径的值，则把最短路径进行重新赋值
                //graph.getMatrix()[k][j] 表示Vk到Vx的权值+min表示间接的V0到Vx的权值
                if (!isgetPath[j] && (min+graph.getMatrix()[k][j])< shortTablePath[j] ){
                    shortTablePath[j] = min+graph.getMatrix()[k][j];
                }
            }

        }

        for(int i = 0;i<shortTablePath.length;i++){
            System.out.println("V0到V"+i+"的最短路径为:"+shortTablePath[i]+"\n");
        }


    }

}
