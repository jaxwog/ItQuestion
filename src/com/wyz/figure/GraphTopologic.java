package com.wyz.figure;

import java.util.Stack;

/**
 * 图（有向图）的拓扑排序
 */
public class GraphTopologic {

    private int numVertexes;
    private VertexNode[] adjList;//邻接顶点的一维数组

    public GraphTopologic(int numVertexes) {
        this.numVertexes = numVertexes;
    }


    public static void main(String[] args) {
        GraphTopologic dnGraphTopologic = new GraphTopologic(14);
        dnGraphTopologic.createGraph();
        try {
            dnGraphTopologic.topologicalSort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拓扑排序
     */
    private void topologicalSort() throws Exception {
        Stack<Integer> stack = new Stack<>();//存数组下标
        int count = 0;
        int k = 0;
        //首次进入把入度为0的数据添加到栈中
        for (int i = 0; i < numVertexes; i++) {
            if (adjList[i].in == 0) {
                stack.push(i);
                System.out.println("顶点：" + adjList[i].data + "已经入栈");
            }
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            System.out.println("------>顶点：" + adjList[pop].data + "已经出栈");
            count++;//记录出栈多少个

            for (EdgeNode node = adjList[pop].firstEdge; node != null; node = node.next) {
                k = node.adjVert;//下标
                if (--adjList[k].in == 0) {
                    stack.push(k);//入度为0,入栈
                    System.out.println("顶点：" + adjList[k].data + "已经入栈");
                }
            }
        }

        if (count < numVertexes) {
            throw new Exception("完犊子了，拓扑排序失败了");
        }

    }

    private void createGraph() {
        VertexNode node0 = new VertexNode(0, "v0");
        VertexNode node1 = new VertexNode(0, "v1");
        VertexNode node2 = new VertexNode(2, "v2");
        VertexNode node3 = new VertexNode(0, "v3");
        VertexNode node4 = new VertexNode(2, "v4");
        VertexNode node5 = new VertexNode(3, "v5");
        VertexNode node6 = new VertexNode(1, "v6");
        VertexNode node7 = new VertexNode(2, "v7");
        VertexNode node8 = new VertexNode(2, "v8");
        VertexNode node9 = new VertexNode(1, "v9");
        VertexNode node10 = new VertexNode(1, "v10");
        VertexNode node11 = new VertexNode(2, "v11");
        VertexNode node12 = new VertexNode(1, "v12");
        VertexNode node13 = new VertexNode(2, "v13");
        adjList = new VertexNode[numVertexes];
        adjList[0] = node0;
        adjList[1] = node1;
        adjList[2] = node2;
        adjList[3] = node3;
        adjList[4] = node4;
        adjList[5] = node5;
        adjList[6] = node6;
        adjList[7] = node7;
        adjList[8] = node8;
        adjList[9] = node9;
        adjList[10] = node10;
        adjList[11] = node11;
        adjList[12] = node12;
        adjList[13] = node13;
        //后继结点中的如果包含相同的需要重新创建对象，并不是同一个东西（边表顶点都是一个新的对象）
        //node0的后继结点表示node0的出度指向的结点，包括11、5、4三个结点
        node0.firstEdge = new EdgeNode(11);
        node0.firstEdge.next = new EdgeNode(5);
        node0.firstEdge.next.next = new EdgeNode(4);
        node1.firstEdge = new EdgeNode(8);
        node1.firstEdge.next = new EdgeNode(4);
        node1.firstEdge.next.next = new EdgeNode(2);
        node2.firstEdge = new EdgeNode(9);
        node2.firstEdge.next = new EdgeNode(6);
        node2.firstEdge.next.next = new EdgeNode(5);
        node3.firstEdge = new EdgeNode(13);
        node3.firstEdge.next = new EdgeNode(2);
        node4.firstEdge = new EdgeNode(7);
        node5.firstEdge = new EdgeNode(12);
        node5.firstEdge.next = new EdgeNode(8);
        node6.firstEdge = new EdgeNode(5);
        node8.firstEdge = new EdgeNode(7);
        node9.firstEdge = new EdgeNode(11);
        node9.firstEdge.next = new EdgeNode(10);
        node10.firstEdge = new EdgeNode(13);
        node12.firstEdge = new EdgeNode(9);
    }


    //边表顶点（后面的链表）
    class EdgeNode {
        private int adjVert;//下标指针，标注了在数组中的位置
        private EdgeNode next; //后继结点
        private int weight;//权重

        public EdgeNode(int adjVert) {
            this.adjVert = adjVert;
        }

        public int getAdjVert() {
            return adjVert;
        }

        public void setAdjVert(int adjVert) {
            this.adjVert = adjVert;
        }

        public EdgeNode getNext() {
            return next;
        }

        public void setNext(EdgeNode next) {
            this.next = next;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

    }

    //邻接顶点(存储在数组中的数据)
    class VertexNode {
        private int in;//入度
        private String data;//数据域
        private EdgeNode firstEdge;//指向后面的链表（相当于头指针）

        public VertexNode(int in, String data) {
            this.in = in;
            this.data = data;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public EdgeNode getFirstEdge() {
            return firstEdge;
        }

        public void setFirstEdge(EdgeNode firstEdge) {
            this.firstEdge = firstEdge;
        }

    }

}
