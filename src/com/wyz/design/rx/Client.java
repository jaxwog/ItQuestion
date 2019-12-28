package com.wyz.design.rx;

/**
 * com.wyz.design.rx
 * Created by jax on 2019/12/20 18:25
 * TODO:
 */
public class Client {

    public static void main(String[] args) {
//                click();
        change();
    }

    private static void click() {
        /**
         * 1、new OnSubscriable<String>养羊的来到集市
         * 2、Observable.create静态方法创建集市
         * 3、new Subscrible<String> 创建一个铁匠
         * 4、subscrible 打铁的来到集市
         * 5、铁匠来到集市后，在通知养羊的人调用call方法（把自身传进去）
         */
        Observable.create(new OnSubscriable<String>() {
            @Override
            public void call(Subscrible<? super String> subscrible) {
                System.out.println("1");
                //拿到了铁匠的引用之后  开始命令铁匠打铁
                subscrible.onNext("开始打铁");
            }
        }).subscrible(new Subscrible<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("2");
                System.out.println("3" + s);
            }
        });

    }

    public static void change() {
        /**
         * String  代表羊
         * Integer   铁
         */
        //Observable集市   OnSubscriable养羊的人
        /**
         * 1、new OnSubscriable<String>养羊的人来到集市
         * 2、Observable.create 静态方法创建羊集市
         * 3、创建装换函数 new Func1<String, Integer>
         * 4、map 创建了一个铁器市场，把羊转换为铁，Observable 铁的集市
         * 6、map创建了一个中介，中介通过call方法把铁匠返回了过来
         * 7、new Subscrible<Integer> 创建了一个卖铁的人
         * //关键步骤，市场的转换
         * 8、此时市场为铁器市场 new OnSubsricbleLift，表示创建商人来到了铁器的集市
         * 9、 onSubscriable.call(subscrible);此时的onSubscriable表示是商人的call方法
         * 10、parent.call(st);parent表示养羊的人，st代表真正打铁的人
         * 11、真正的铁匠来到铁器市场集市后，在通知养羊的人调用call方法（把自身传进去），
         *    此时的Subscrible<? super String> subscrible，表示的是真正的铁匠
         * 12、 subscrible.onNext("羊"); 此时的subscrible表示的是真正打杀猪刀得人
         * 13、 actual.onNext(r);得到了铁，交给卖铁的人进行处理
         *     actual代表了new Subscrible<Integer>
         */
        System.out.println("当前线程："+Thread.currentThread().getName());
        Observable.create(new OnSubscriable<String>() {
            //Subscrible 卖铁的
            @Override
            public void call(Subscrible<? super String> subscrible) {
                System.out.println("切换后线程："+Thread.currentThread().getName());
                System.out.println("1  养羊的人：我要铁");
                subscrible.onNext("羊");
                System.out.println("1  养羊的人");
            }
        })
                // Func1 铸铁的是如何跟养羊进行交换
         .map(new Func1<String, Integer>() {
                    //羊---》》铁
                    @Override
                    public Integer call(String s) {
                        System.out.println("2 我得到了羊="+s);
                        Integer bitmap = 33;
                        System.out.println("2 开始转换  羊="+s+"---》铁"+bitmap);
                        return bitmap;
                    }
                })
                .subscribleOnIO()
                //subscrible订阅  Subscrible卖铁的人
         .subscrible(new Subscrible<Integer>() {
                    @Override
                    public void onNext(Integer bitmap) {
                        System.out.println("3 得到了铁" + bitmap);
                    }
                });
    }



}
