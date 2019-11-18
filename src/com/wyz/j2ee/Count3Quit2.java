package com.wyz.j2ee;

/**
 * 500个小孩组成一圈,每数到三就去掉一个，剩下的最后一个在什么位置
 * 类包括：小孩，圈
 *
 */
public class Count3Quit2 {
    KidCircle kc;
    int countNum;
    Kid kid;
    public Count3Quit2(){
        kc= new KidCircle(500);
        countNum = 0;
        kid = kc.first;
    }

   public void start(){

        while(kc.count>1){
            countNum++;
            if (countNum==3){
                countNum=0;
                kc.delete(kid);
            }
            kid = kid.right;
        }
        System.out.print(kc.first.id);
    }

}

//属性：位置编号，左手的小孩，右手的小孩
class Kid{
    int id;
    Kid left;
    Kid right;
}

//小孩组成一个圈，传入参数是一个小孩(循环双链表)
class KidCircle{
    int count;
    Kid first,last;
    //构造方法用来创建多少个小孩
    public KidCircle(int n){
        for (int i = 0; i < n; i++) {
            add();
        }
    }

    void add(){
        Kid kid = new Kid();
        kid.id = count;
        if (count<=0){
            first = kid;
            last = kid;
            kid.left =kid;
            kid.right = kid;
        }else {
            last.right = kid;
            kid.left = last;
            kid.right = first;
            first.left = kid;
            last = kid;
        }
        count ++;

    }

    void delete(Kid kid){
        if (count<=0){
            return;
        }else if (count ==1){
            first = last  = null;
        }else {
            kid.left.right = kid.right;
            kid.right.left = kid.left;
            if (kid == first){
                first = kid.right;
            }else if (kid == last){
                last = kid.left;
            }
        }

        count--;

    }

}

