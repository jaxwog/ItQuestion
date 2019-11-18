package com.wyz.linearlist;

/**
 * 用链式存储结构实现的线性表称为链表，链表的节点个数称为链表的长度；
 * 如果链表中每个节点自有一个链称为：单链表
 * 带头结点的单链表类，实现线性表接口
 * 是一种顺序存取结构，不是随机存取结构。
 *  isEmpty() 时间复杂度为O(1)
 * length() 、get(int i)、set(int i, T x)时间复杂度为O(n)
 *在指定结点后插入新结点的操作，时间复杂度为O(1)；
 * 在指定结点前插入新结点的操作，时间复杂度为O(n)；
 * 删除指定结点后的结点的操作，时间复杂度为O(1)；
 * 删除指定结点的操作，时间复杂度为O(n)；
 *
 * 提高单链表的效率措施
 * ①   insert(this.length(), x);//需遍历单链表两次，效率较低
 * insert(Integer.MAX_VALUE, x);  //遍历一次
 * ②参考如下toString方法
 * ③如果在单链表中增加某些私有成员变量，则可提高某些操作效率。
 * 增加成员变量len表示单链表长度。可以使得length()的时间复杂度为O(1)；
 * 增加成员变量rear作为单链表的尾指针，指向最后一个结点。可以使得尾部插入的时间复杂度为O(1)
 *
 * 顺序表和单链表比较
 * 访问元素性能：顺序表能直接访问随机元素（随机存取）；链表不能直接访问，需要从第一个结点开始依次查找（顺序存取）
 * 存储空间：顺序表插入元素如果为满，需要从新申请空间；链表每插入一个结点申请空间
 * 存储密度：结点数据本身所占的存储量和整个结点结构所占的存储量之比。顺序表为1，链表包含前驱或后继，密度<1
 * 插入和删除操作：顺序表需要移动大量的元素；链表只需改动相关的链不需要移动元素
 */
public class SinglyLinkedList<T> implements LList<T>{

    public Node<T> head;                             //头指针，指向单链表的头结点

    public SinglyLinkedList()                         //默认构造方法，构造空单链表
    {
        this.head = new Node<T>();                    //创建头结点，data和next值均为null
    }

    /*
        由指定数组中的多个对象构造单链表。采用尾插入构造单链表.
        若element==null，Java将抛出空对象异常；若element.length==0，构造空链表。
     */
    public SinglyLinkedList(T[] element){
        this();                                             //创建空单链表，只有头结点
        Node<T> rear = this.head;                           //rear指向单链表最后一个结点
        for (int i=0; i<element.length; i++)          //若element==null，抛出空对象异常
        {                                             //element.length==0时，构造空链表
            rear.next=new Node<T>(element[i],null);   //尾插入,创建结点链入rear结点之后
            rear = rear.next;                         //rear指向新的链尾结点
        }

    }


    //判断单链表是否空，O(1)
    @Override
    public boolean isEmpty() {
        return this.head.next==null;
    }

    //以下length()、toString()、get()、set()方法基于单链表遍历算法, 返回单链表长度，O(n)
    @Override
    public int length() {
        Node<T> p = this.head.next;                 //p从单链表第一个结点开始
        int i = 0;
        while (p!=null){
            i++;
         // System.out.print(p.data+",");
          p = p.next;                                //p到达后继结点
        }
       // System.out.println();
        return i;
    }

    @Override
    public T get(int i) {

        if (i>=0)
        {
            Node<T> p=this.head.next;          //获取到头head的next参数p，p为链表的起始位置0的元素
            for (int j=0; p!=null && j<i; j++){
                p = p.next;
            }
            if (p!=null) {
                return p.data;                   //p指向第i个结点，返回数据内容
            }
        }
        return null;

    }

    @Override
    public void set(int i, T x) {

        if (x==null) {
            return;                    //不能设置元素为空对象
        }
        Node<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++) {
            p = p.next;
        }
        if (i>=0 && p!=null) {
            p.data = x;                                    //p指向第i个结点
        }else {
            throw new IndexOutOfBoundsException(i + "");    //抛出序号越界异常
        }

    }

    @Override
    public void insert(int i, T x) {
        if (x==null) {
            return;                         //不能插入空对象
        }
        Node<T> p=this.head;                          //p指向头结点
        for (int j=0;  p.next!=null && j<i;  j++) {    //寻找插入位置
            p = p.next;
        }                          //循环停止时，p指向第i-1结点或最后一个结点
        p.next = new Node<T>(x, p.next);              //插入x作为p结点的后继结点，包括头插入（i<=0）、中间/尾插入（i>0）
    }

    @Override
    public void append(T x) {
        // insert(this.length(), x);    //需遍历单链表两次，效率较低

        insert(Integer.MAX_VALUE, x);  //遍历一次
    }

    @Override
    public T remove(int i) {
        if (i>=0)
        {
            Node<T> p=this.head;
            for (int j=0;  p.next!=null && j<i;  j++){
                p = p.next;                               // 循环停止时，p指向第i-1结点
            }
            if (p.next!=null)
            {
                T old = p.next.data;
                p.next = p.next.next;               //指向删除前节点指向的下一个节点
                return old;
            }
        }
        return null;

    }

    @Override
    public void removeAll() {
        this.head.next=null;
    }

    @Override
    public T search(T key) {
        return null;
    }

    //返回单链表所有元素的描述字符串，形式为“(,)”，覆盖Object类的toString()方法，O(n)
    @Override
    public String toString() {
        String str="(";
        for (Node<T> p = this.head.next;  p!=null;  p=p.next)
        {   str += p.data.toString();
            if (p.next!=null)
                str += ",";                                //不是最后一个结点时后加分隔符
        }
        return str+")";                                    //空表返回()
    }


    public Node<T> getFirst()                    //返回单链表第一个元素结点（非头结点），O(1)
    {
        return this.head.next;                   //若单链表空返回null
    }
    public Node<T> getNext(Node<T> p)            //返回p的后继结点，O(1)
    {
        if (this.head.next==null || p==null)
            return null;
        return p.next;
    }

    public Node<T> getPred(Node<T> p)            //返回p的前驱结点，O(n)
    {
        if (p==null || this.head.next==p){
            return null;
        }
        Node<T> front=this.head.next;
        while (front!=null && front.next!=p){   //采用从头依次循环的方式试探是否为p的前置节点
            front = front.next;
        }
        return front;
    }

    public Node<T> getLast()                     //返回单链表最后一个元素结点，O(n)
    {
        Node<T> p=this.head.next;
        while (p!=null && p.next!=null)
            p = p.next;
        return p;                                //若单链表空返回null
    }

/*作用于顺序表的时间复杂度是O(n)， 但作用于单链表的时间复杂度则是O(n*n)
    public String toString()
    {
        String str="(";
        if (this.length()!=0){
            for(int i=0; i<this.length()-1; i++)
                str += this.get(i).toString()+", ";
            str += this.get(this.length()-1).toString();
        }
        return str+")";
    }

 */

    public SinglyLinkedList(SinglyLinkedList<T> list){
        this();
        Node<T> p = list.head.next;
        Node<T> rear = list.head;
        while (p!=null){
            rear.next = new Node<T>(p.data,null);
            rear = rear.next;
            p = p.next;
        }
    }
/**
 * ①拷贝构造函数，浅拷贝。导致两个引用变量指向同一个结点(没有实际复制单链表功能)
 * public SinglyLinkedList(SinglyLinkedList<T> list){this.head = list.head;}
 * ②深拷贝构造方法不彻底，虽然复制了所有结点，但是没有复制元素对象，导致两条单链表中对应两个结点仍然引用同一个对象。
 * java中没有提供T默认拷贝构造方法，不能实现参数为T的深度拷贝功能。复制元素对象的深拷贝方法有指定T实际参数的类提供。
 public SinglyLinkedList(SinglyLinkedList<T> list){
 this();
 Node<T> p = list.head.next;
 Node<T> rear = list.head;
 while (p!=null){
 rear.next = new Node<T>(p.data,null);
 rear = rear.next;
 p = p.next;
      }
 }
 */

}
