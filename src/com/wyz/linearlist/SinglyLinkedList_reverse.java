package com.wyz.linearlist;

/**
 * 单链表逆转
 * ①初始，设置p指向第一个结点，front指向p的前驱，succ指向p的后继
 * ②循环中，使p.next指向前驱结点front，front、p、succ各向后移动一个结点
 * ③循环结束后，设置front为头结点，单链表逆转完成
 */
public class SinglyLinkedList_reverse {

    //将单链表逆转，泛型方法，返回值类型前声明类型参数T
    public static <T> void reverse(SinglyLinkedList<T> list) {

        Node<T> p = list.head.next; //head必须声明为public
        Node<T> succ = null;           //p的后继节点
        Node<T> front = null;          //P的前驱节点

        while (p != null) {
            succ = p.next;
            p.next = front;
            front = p;
            p = succ;
        }
        list.head.next = front;

    }
}
