package com.wyz.linearlist;

/**
 * 升序排序的单链表
 */
public class SortedSinglyLinkedList<T extends Comparable<T>> extends SinglyLinkedList<T> {

    public SortedSinglyLinkedList() {
        super();                                           //调用父类默认构造方法，默认调用，可省略
    }

    //将elements数组中所有对象插入构造排序的单链表，直接插入排序
    public SortedSinglyLinkedList(T[] element){
        super();                                           //创建空单链表，调用父类默认构造方法，默认调用，可省略
        for (int i=0; i<element.length; i++)               //若element==null，抛出空对象异常
            this.insert(element[i]);                       //插入一个结点，根据值的大小决定插入位置
    }

    //插入值为x结点，根据x值大小插入在合适位置
    //重载父类的insert(i,x)方法，因参数不同没有覆盖父类的insert(i,x)方法
    public void insert(T x) {

        if (x==null)
            return;                                         //不能插入空对象
        Node<T> front=this.head, p=front.next;             //front是p的前驱结点
        while (p!=null && p.data.compareTo(x)<0)           //寻找插入位置
        {
            front = p;
            p = p.next;
        }
        front.next = new Node<T>(x, p);                    //创建结点插入在front之后，p之前
    }

    @Override
    public void insert(int i, T x) {
        throw new UnsupportedOperationException("insert(int i, T x)"); //本类不支持该方法
    }

    @Override
    public void append(T x) {
        throw new UnsupportedOperationException("append(T x)");    //本类不支持该方法
    }


    //删除首次出现的值为x结点，若没找到指定结点则不删除。O(n)
    //重载父类的remove(T x)方法，因参数不同没有覆盖父类的remove(T x)方法
    public void remove(T x)
    {
        if (x==null)
            return;
        Node<T> front=this.head, p=front.next;        //front是p的前驱结点
        while (p!=null && p.data.compareTo(x)<0)      //寻找待删除的结点
        {
            front = p;
            p = p.next;
        }
        if (p!=null && p.data.compareTo(x)==0)
            front.next = p.next;                      //删除p结点
    }

    //深拷贝构造方法，复制单链表
    public SortedSinglyLinkedList(SortedSinglyLinkedList<T> list)
    {
        super(list);                             //调用父类同参数的构造方法，不可省略
        
    }
}
