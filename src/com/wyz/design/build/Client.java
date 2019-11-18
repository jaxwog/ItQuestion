package com.wyz.design.build;

/**
 * com.wyz.design.build
 * Created by jax on 2019/11/14 16:19
 * TODO:房屋主人
 *
 */
public class Client {
    public static void main(String[] args) {
         IBuild worker = new WorkBuilder(); //获取工人对象
         Designer  designer = new  Designer();   //获取设计师对象
         designer.order(worker);    //设计师指挥工人工作
         System.out.println(worker.getRoom());;   //工人交房
      }
    /**
     * 构建者模式
     * 定义：将一个复杂的构建与它的表示分离，使得同样的同样的构建过程可以创建不同的表示
     * 4种角色：
     * 1、抽象建造者：给出一个抽象接口，定义了各个工人所需要进行的工作。这些工作是为了完成对房子的创建（工地指导手册）；
     * 2、具体建造者：具体建造者（农民工）去造房子，房子造完后，需要将房子还给房屋主人，所以需要有返回房子的方法；
     * 3、产品（房子）：房子会有哪些什么属性
     * 4、设计者：
     *  ①知道房屋怎么设计（设计屋顶、地板等）
     *  ②指挥工人去建造（肯定持有工人这个对象的引用）
     *  ③对工人的所具备的能力和行为有很深的了解
     *  ④从整体角度出发，什么样的房子都能给你建成。他所具备的功能可以覆盖你的完整需求。哪怕业主只提出只建造简单的房子，但是他所具备的能力必须完全覆盖。
     *
     */

}
