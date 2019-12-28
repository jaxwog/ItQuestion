package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 11:36
 * TODO:被观察者  养羊的人  表示的类的方式
 *  T  代表打铁
 *  命令铁匠   打铁
 *  铁匠 --》  打铁的工匠
 *  没有添加成员，扩充了泛型
 * *****************
 * extends  可用于的返回类型限定，不能用于参数类型的限定
 * super    可用于参数类型的限定，不能用于返回类型的限定
 *  只有一个 ？表示什么都不限定
 * < ? extends E >
 * add： 不允许加入 任何 元素！
 * get： 可以获取元素，但是必须使用 E 来接受元素！
 * < ? super E >
 * add: 允许添加 E和E的子类 元素！
 * get: 可以获取元素，但是类的信息丢失了，所以返回只能使用Object引用来接受！如果需要自己的类型需要强制类型转换！
 *
 * 原文链接：https://blog.csdn.net/Justin_zhao/article/details/77750440
 *
 * T 打铁；  Subscrible<? super T>打铁的工匠
 */
public interface OnSubscriable<T> extends Action1<Subscrible<? super T>> {

}
