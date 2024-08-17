package com.wyz.array;

/**
 * 泊松倒酒:穷举法
 * 有一个12品脱(pint)的酒瓶，里面装满葡萄酒，另有8品脱和5品脱的瓶子各一个。问如何从中分出6品脱的酒出来？
 * 规则:b1-->b2-->b3-->b1
 * 1、只有b2瓶子为空时，b1才往b2瓶子里倒酒
 * 2、只有瓶子b3为空时，b2才往b3瓶子里倒酒
 * 3、只有瓶子b3为满时，b3才往b1瓶子里倒酒
 */
public class ShareWine {

    //瓶子容量大小
    private static final int b1 = 12;
    private static final int b2 = 8;
    private static final int b3 = 5;
    private static final int m = 9;//目标酒量

    public static void main(String[] args) {

        backBottle(12, 0, 0);
    }

    //三个酒瓶的初始容量
    private static void backBottle(int bb1, int bb2, int bb3) {
        System.out.println("瓶子1中：" + bb1 + "----瓶子2中：" + bb2 + "----瓶子3中：" + bb3);
        if (bb1 == m || bb2 == m || bb3 == m) {
            System.out.println("已经找到了目标容量" + m);
            return;
        }
        //如果瓶子2不为空，并且瓶子3没有装满,就可以把往瓶子3装
        if (bb2 != 0 && bb3 != b3) {
            if (bb2 + bb3 <= b3) {
                //如果2和3的剩余酒量小于3的容量，全部倒入到3中
                backBottle(bb1, 0, bb2 + bb3);
            } else {
                backBottle(bb1, bb2 - (b3 - bb3), b3);
            }

            //如果瓶子3已经装满了，倒入到瓶子1中
        } else if (bb3 == b3) {
            //瓶子1和3中酒量加在一起没有达到瓶子1容量
            if (bb1 + bb3 <= b1) {
                backBottle(bb1 + bb3, bb2, 0);
            } else {
                backBottle(b1, bb2, b3 - (b1 - bb1));
            }
            //如果瓶子2为空,就把瓶子1的酒倒入瓶子2中
        } else if (bb2 == 0) {
            //如果瓶子1中的酒没有装满瓶子2，直接倒入到瓶子2
            if (bb1 <= b2) {
                backBottle(0, bb1, bb3);
            } else {
                backBottle(bb1 - b2, b2, bb3);
            }


        }


    }

}


/**
 * com.wyz.array
 * Created by jax on 2020/5/15 13:57
 * TODO:
 * 1. 大瓶子只能倒入中瓶子
 * <p>
 * 2. 中瓶子只能倒入小瓶子
 * <p>
 * 3. 小瓶子只能倒入大瓶子
 * <p>
 * 4. 小瓶子只有在已经装满的情况下才能倒入大瓶子
 * <p>
 * 5. 若小瓶子被倒空，则无论中瓶子是否满，应马上从中瓶子倒入小瓶子
 */
/*public class TestShare {

    //瓶子容量大小
    private static final int b1 = 12;
    private static final int b2 = 8;
    private static final int b3 = 5;
    private static final int m =9;//目标酒量

    public static void main(String[] args) {
        backBottle(12,0,0);

    }

    //初始容量
    private static void backBottle(int bb1,int bb2,int bb3){
        System.out.println("瓶子1中："+bb1+"----瓶子2中："+bb2+"----瓶子3中："+bb3);

        if (bb1==m || bb3==m || bb2==m){
            System.out.println("已经分好酒了");
            return;
        }

        //
        if (bb3==b3){
            if (bb1+b3>b1){
                backBottle(b1,bb2,bb1+b3-b1);
            }else {
                backBottle(bb1+bb3,bb2,0);
            }
        } else if (bb3==0 && bb2!=0){
            if (bb2>b3){
                backBottle(bb1,bb2-b3,b3);
            }else {
                backBottle(bb1,0,bb2);
            }
        } else   if (bb1!=0 && bb2!=b2){
            if (bb1+bb2>b2){
                backBottle(bb1-(b2-bb2),b2,bb3);
            }else {
                backBottle(0,bb1+bb2,bb3);
            }
        }




    }
}*/

