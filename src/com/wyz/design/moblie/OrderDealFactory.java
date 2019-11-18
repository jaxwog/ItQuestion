package com.wyz.design.moblie;

/**
 * com.wyz.design.moblie
 * Created by jax on 2019/11/7 10:23
 * TODO:订单工厂，把订单进行拆分 拷贝
 */
public class OrderDealFactory {
    public void dealOrder(IOrder order) {
        System.out.println("原订单地址  ：  " + order.hashCode());
        int number = order.getOderNumber();
        while (number > 0) {
//            IOrder iOrder = null;
//            if (order instanceof PersonOrder) {
//                //个人订单，不采用原型模式，每次拷贝出来数据内容（不操作原始数据，深拷贝）
//                PersonOrder personOrder = (PersonOrder) order;
//                PersonOrder newPersonOrder = new PersonOrder();
//                newPersonOrder.setOderNumber(number > 1000 ? 1000 : number);
//                newPersonOrder.setName(personOrder.getName());
//                iOrder = newPersonOrder;
//                System.out.println("订单----   name  " + newPersonOrder.getName() + "   number  " + newPersonOrder.getOderNumber() +
//                        "地址  :  " + newPersonOrder.hashCode());
//                number -= 1000;
//                /**
//                 * 处理下一步订单
//                 */
//            } else if (order instanceof CompanyOrder) {
//
//
//            }

            IOrder iOrder=(IOrder) order.cloneOrder();
            iOrder.setOderNumber(number>1000?1000:number);
            number-=1000;
            System.out.println("订单----     number  "+iOrder.getOderNumber()+
                    "地址  :  "+iOrder.hashCode());


        }
    }
}
