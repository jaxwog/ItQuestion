package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 23:24
 * TODO:卖铁的人  商人
 * T  放羊
 * R  打铁
 * OnSubscriable<R> 代表这个人是卖铁的
 */
public class OnSubsricbleLift<T, R> implements OnSubscriable<R> {

    /**
     * 卖铁的角色肯定持有放羊的人的引用
     */
    OnSubscriable<T>                 parent;
    //R  铁   T  羊
    /**
     * 中介
     *   拿着猪肉 去 换杀猪刀
     *   杀猪刀 作为返回类型    猪肉作为  参数类型
     *   杀猪刀  call (猪肉）
     *   extends   返回类型的限定
     *   super     参数类型的限定
     *   T  猪肉
     *   R 杀猪刀
     */
    Operator<? extends R, ? super T> operator;

    public OnSubsricbleLift(OnSubscriable<T> parent, Operator<? extends R, ? super T> operator) {
        this.parent = parent;
        this.operator = operator;
    }

    //call目的  让中介 返回打杀猪刀的朋友
    @Override
    public void call(Subscrible<? super R> subscrible) {
        /**
         *   卖铁的人为了满足 养羊的人的需求
         *   通过千辛万苦 间接拿到了  真正打铁的人
         *
         * st 代表打铁的人
         * parent  放羊的人
         *
         * MapSubscrble正真铸铁的人
         *  parent 放羊的人
         */

         /*
    operator  中介
    Subscrible  打杀猪刀的人
     */
        Subscrible<? super T> st = operator.call(subscrible);
        //---------未执行---
        // 商人直接将  打杀猪刀的朋友  丢给  屠夫
        //目的  打把杀猪刀
        parent.call(st);
    }
}
