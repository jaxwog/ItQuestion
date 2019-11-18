package com.wyz.linearlist;

/**
 * 循环双链表
 *
 */
public class CirDoublyLinkedList<T> implements LList<T> {

   public DLinkNode<T> head;

   public CirDoublyLinkedList(){
       this.head = new DLinkNode<T>();    //创建头结点，三个域值均为空
       this.head.prev = head;
       this.head.next = head;
    }
   //由指定数组中的多个对象构造循环双链表，采用尾插入构造循环双链表
    public CirDoublyLinkedList(T[] element){
       this();             //创建空循环双链表，只有头结点
        DLinkNode<T> rear = this.head;
        for (int i = 0; i < element.length; i++) {
            rear.next = new DLinkNode<T>(element[i],rear,this.head);  //尾部插入
            rear = rear.next;
        }
       this.head.prev = rear;

    }


    @Override
    public boolean isEmpty() {
        return this.head.next==this.head && this.head.prev==this.head;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public T get(int i) {
        return null;
    }

    @Override
    public void set(int i, T x) {

    }


    //插入第i（≥0）个元素值为x。若x==null，不插入。
    //若i<0，插入x作为第0个元素；若i大于表长，插入x作为最后一个元素。O(n)
    @Override
    public void insert(int i, T x) {
        if (x==null)  return;                              //不能插入空对象
        DLinkNode<T> p=this.head;
        for (int j=0; p.next!=this.head && j<i; j++)       //寻找插入位置
            p = p.next;                                    //循环停止时，p指向第i-1个结点
        DLinkNode<T> q=new DLinkNode<T>(x, p, p.next);     //插入在p结点之后，包括头插入、中间插入
        p.next.prev = q;
        p.next = q;
    }

    @Override
    public void append(T x) {
        if (x==null)  return;                              //不能添加空对象
        DLinkNode<T> q = new DLinkNode<T>(x, head.prev, head);
        head.prev.next = q;                                //插入在头结点之前，相当于尾插入
        head.prev = q;
    }

    @Override
    public T remove(int i) {
        if (i>=0)
        {
            DLinkNode<T> p=this.head.next;
            for (int j=0; p!=head && j<i; j++)             //定位到待删除结点
                p = p.next;
            if (p!=head)
            {
                T old = p.data;                            //获得原对象
                p.prev.next = p.next;                      //删除p结点自己
                p.next.prev = p.prev;
                return old;
            }
        }
        return null;                                       //当i<0或大于表长时
//        throw new IndexOutOfBoundsException(i+"");         //抛出序号越界异常
    }

    @Override
    public void removeAll() {
        this.head.prev = head;
        this.head.next = head;

    }

    @Override
    public T search(T key) {
        return null;
    }
}
    /**
          ① 在p结点之前插入值为x结点
            q = new DLinkNode<T>(x, p.prev, p);
            p.prev.next = q;
            p.prev = q;
     ②在p后插入结点q
     q = new DLinkNode<T>(x, p, p.next);
     //当p.next==null时，尾插入
     if (p.next!=null)
     p.next.prev = q;     //中间插入时执行
     p.next = q;

     删除p结点
     p.prev.next = p.next;
     if (p.next!=null)
     p.next.prev = p.prev;

     *
 */
