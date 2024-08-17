package com.wyz.j2ee.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * com.wyz.j2ee.reflection
 * Created by jax on 2020/1/19 15:14
 * TODO:java反射API操作
 * 1.Class类
 *   1） 在面向对象的世界里，万事万物皆对象。（java语言中，静态的成员、普通数据类型除外)
 *    类是不是对象呢?类是(哪个类的对象呢?)谁的对象呢?
 *    类是对象，类是java.lang.Class类的实例对象
 *   2）这个对象到底如何表示
 *   3 )Class.forName("类的全称")
 *        不仅表示了，类的类类型，还代表了动态加载类
 *        请大家区分编译、运行
 *        编译时刻加载类是静态加载类、运行时刻加载类是动态加载类
 *   4)基本的数据类型
 *       void关键字  都存在类类型
 *   5)Class类的基本API操作
 * <p>
 * 2.方法的反射
 * 1）如何获取某个方法
 * 方法的名称和方法的参数列表才能唯一决定某个方法
 * 2)方法反射的操作
 * method.invoke(对象，参数列表)
 * 3)为什么要用方法的反射
 * why?指定方法名称调用方法
 * 举个实际应用的案例  ---->通过标准JavaBean的属性名获取其属性值
 * BeanUtil类
 * 4)通过Class,Method来认识泛型的本质
 */
public class Client {

    public static void main(String[] args) {


        Class c01 = int.class;//int 的类类型
        Class c02 = String.class;//String类的类类型   String类字节码（自己发明的)
        Class c03 = double.class;
        Class c04 = Double.class;
        Class c05 = void.class;

        System.out.println(c01.getName());
        System.out.println(c02.getName());
        System.out.println(c02.getSimpleName());//不包含包名的类的名称
        System.out.println(c03.getName());
        System.out.println(c04.getName());
        System.out.println(c05.getName());
        System.out.println("====================================");

        //Foo的实例对象如何表示
        Foo foo1 = new Foo();//foo1就表示出来了.
        //Foo这个类 也是一个实例对象，Class类的实例对象,如何表示呢
        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式

        //第一种表示方式--->实际在告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c11 = Foo.class;

        //第二中表达方式  已经知道该类的对象通过getClass方法
        Class c12 = foo1.getClass();

        /*官网 c1 ,c2 表示了Foo类的类类型(class type)
         * 万事万物皆对象，
         * 类也是对象，是Class类的实例对象
         * 这个对象我们称为该类的类类型
         *
         */

        //不管c1  or c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c11 == c12);

        //第三种表达方式
        Class c13 = null;
        try {
            c13 = Class.forName("com.wyz.j2ee.reflection.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c12 == c13);

        //我们完全可以通过类的类类型创建该类的对象实例---->通过c1 or c2 or c3创建Foo的实例对象
        try {
            Foo foo = (Foo) c11.newInstance();//需要有无参数的构造方法
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("====================================");
        String s = "hello";
        ClassUtil.printClassMethodMessage(s);

        System.out.println("====================================");
        Integer n1 = 1;
        ClassUtil.printClassMethodMessage(n1);

        System.out.println("====================================");
        ClassUtil.printFieldMessage("hello");
        System.out.println("====================================");
        ClassUtil.printFieldMessage(new Integer(1));

        System.out.println("====================================");
        ClassUtil.printConMessage("hello");
        System.out.println("====================================");
        ClassUtil.printConMessage(new Integer(1));
        System.out.println("====================================");
        System.out.println("====================================");


        //要获取print(int ,int )方法  1.要获取一个方法就是获取类的信息，获取类的信息首先要获取类的类类型
        A a1 = new A();
        Class c = a1.getClass();
        /*
         * 2.获取方法 名称和参数列表来决定
         * getMethod获取的是public的方法
         * getDelcaredMethod自己声明的方法
         */
        try {
            //Method m =  c.getMethod("print", new Class[]{int.class,int.class});
            Method m = c.getMethod("print", int.class, int.class);

            //方法的反射操作
            //a1.print(10, 20);方法的反射操作是用m对象来进行方法调用 和a1.print调用的效果完全相同
            //方法如果没有返回值返回null,有返回值返回具体的返回值
            //Object o = m.invoke(a1,new Object[]{10,20});
            Object o = m.invoke(a1, 10, 20);
            System.out.println("==================");
            //获取方法print(String,String)
            Method m1 = c.getMethod("print", String.class, String.class);
            //用方法进行反射操作
            //a1.print("hello", "WORLD");
            o = m1.invoke(a1, "hello", "WORLD");
            System.out.println("===================");
            //  Method m2 = c.getMethod("print", new Class[]{});
            Method m2 = c.getMethod("print");
            // m2.invoke(a1, new Object[]{});
            m2.invoke(a1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("====================================");
        System.out.println("====================================");
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");
        //list1.add(20);错误的
        Class c51 = list.getClass();
        Class c52 = list1.getClass();
        System.out.println(c51 == c52);
        //反射的操作都是编译之后的操作

        /*
         * c1==c2结果返回true说明编译之后集合的泛型是去泛型化的
         * Java中集合的泛型，是防止错误输入的，只在编译阶段有效，
         * 绕过编译就无效了
         * 验证：我们可以通过方法的反射来操作，绕过编译
         */
        try {
            Method m = c52.getMethod("add", Object.class);
            m.invoke(list1, 20);//绕过编译操作就绕过了泛型
            System.out.println(list1.size());
            System.out.println(list1);
			/*for (String string : list1) {
				System.out.println(string);
			}*///现在不能这样遍历
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


class Foo {
    void print() {
        System.out.println("foo");
    }
}


class A {
    public void print() {
        System.out.println("helloworld");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}
