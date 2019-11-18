package com.wyz.design.instance;

/**
 * com.wyz.design.instance
 * Created by jax on 2019/11/7 16:14
 * TODO:单例模式调用
 * 1、引用父类静态字段会不会初始化 之类？ 不会
 * 2、通过自定义对象数组类型，会不会加载改类型 Class[]{Persion.class,Peopel.class} ？ 不会，只有使用（new  或 Class.from()）时才会
 * 3、在类Persion中定义 public static  final int a = 10;  Persion.a  会不会加载Persion类？ 不会（存在常量池中）
 */
public class Client {

    DCLSingle mSingle = DCLSingle.getInstance();
    /**
     * 加载步骤：
     * 1、Client.class字节码 通过类加载器加载（包含main函数）
     * 2、jvm引擎实例
     * 3、内存中开辟空间（主要：方法区（常量池、字节码文件）、java栈（成员变量、指令集、栈帧）、堆内存（实例化对象、反射的对象））
     * 4、把Client.class 文件放入到方法区
     * 5、main方法压入到java栈中（栈帧），①DCLSingle  ②mSingle = ③DCLSingle.getInstance();
     * 6、①常量池中有一个DCLSingle的符号变量，这时引用没有指向真正类信息的地址
     * 7、②将DCLSingle.class 字节码文件加载到内存，这时DCLSingle的符号变量指向class类信息（Class类型只存在一个（对象可以存在多个），
     * 里面存放着该类的方法表，把getinstance压入到栈里面去（栈帧））
     * 8、声明DCLSingle类型， ②变量指向DCLSingle的内存空间
     * 9、在堆区开辟空间 实例化③DCLSingle对象
     * 注意：双检查模式在8或9的地方不安全，采用指令集乱序不能确定是先new对象还是先指向堆内存空间（此时返回的对象为空）
     * 加入volition后，会按照顺序执行指令集，不会造成顺序颠倒
     * 方法中所有的成员变量都是私有的（线程安全的，栈帧是线程私有的），并不是在内存空间开辟的引用
     */


}
