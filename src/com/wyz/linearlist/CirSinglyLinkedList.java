package com.wyz.linearlist;

/**
 * 循环单链表
 *
 * @param <T>
 */
public class CirSinglyLinkedList<T> implements LList<T> {

    public Node<T> head;                              //头指针，指向循环单链表的头结点

    public CirSinglyLinkedList()                      //默认构造方法，构造空循环单链表
    {
        this.head = new Node<T>();                    //创建头结点
        this.head.next = this.head;
    }

    //由element数组中的多个对象构造单链表。采用尾插入构造单链表
    public CirSinglyLinkedList(T[] element) {
        this();                                            //创建空单链表，只有头结点
        Node<T> rear = this.head;                            //rear指向单链表最后一个结点
        for (int i = 0; i < element.length; i++)               //若element==null，抛出空对象异常
        {                                                  //若element.length==0，构造空链表
            rear.next = new Node<T>(element[i], this.head);  //尾插入，创建结点链入rear结点之后
            rear = rear.next;                              //rear指向新的链尾结点
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == this.head;
    }

    @Override
    public int length() {
        int i = 0;
        for (Node<T> p = this.head.next; p != this.head; p = p.next) {
            i++;
        }
        return i;
    }

    @Override
    public String toString() {
        String str = "(";
        Node<T> p = this.head.next;
        while (p != this.head)                          //遍历单链表的循环条件改变了
        {
            str += p.data.toString();
            if (p != this.head)
                str += ", ";                          //不是最后一个结点时后加分隔符
            p = p.next;
        }
        return str + ")";                               //空表返回()
    }

    @Override
    public T get(int i) {
        if (i >= 0) {
            Node<T> p = this.head.next;
            for (int j = 0; p != this.head && j < i; j++) {
                p = p.next;
            }
            if (p != this.head) {
                return p.data;
            }                                              //p指向第i个结点
        }
        return null;                                       //当i<0或大于表长时
    }


    @Override
    public void set(int i, T x) {
        if (x == null) return;                              //不能设置空对象
        Node<T> p = this.head.next;
        for (int j = 0; p != this.head && j < i; j++)
            p = p.next;
        if (i >= 0 && p != this.head)
            p.data = x;                                    //p指向第i个结点
        else throw new IndexOutOfBoundsException(i + "");    //抛出序号越界异常
    }

    @Override
    public void insert(int i, T x) {


    }

    @Override
    public void append(T x) {

    }

    @Override
    public T remove(int i) {
        return null;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public T search(T key) {
        return null;
    }
}
