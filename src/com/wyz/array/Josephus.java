package com.wyz.array;

/**
 * com.wyz.array
 * Created by jax on 2019/11/2 01:50
 * TODO:约瑟芬杀人法
 */
public class Josephus {
    public static int N = 20;
    public static int M = 5;//数到M就咔擦一个人


    class Node{
        int val;//下标
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public void killNode(){
        Node header = new Node(1);//第一个结点
        Node x = header;//目前被点到人
        for(int i = 2;i<=N;i++){
            x=(x.next = new Node(i));
        }
        x.next = header;//头尾相接
        System.out.println("被咔擦的顺序为：");
        while(x!=x.next){//头尾不相连，表示还有多人
            //至少还有俩人，仍然继续报数，咔嚓
            for(int i = 1;i<M;i++){
                //第一遍开始时，x.next为第一个人（此时的x表示最后一个人）
                x = x.next;
            }
            System.out.println(x.next.val+"被干掉 ");
            x.next = x.next.next;
        }
        System.out.println("最后这个幸运儿是："+x.val);
    }

    public static void main(String[] args){
        Josephus josephus = new Josephus();
        josephus.killNode();
    }
}
