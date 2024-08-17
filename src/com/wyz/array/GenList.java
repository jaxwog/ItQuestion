package com.wyz.array;

/**
 * 广义表是线性表的扩展，能表示树结构和图结构
 * 当一个线性表中包含子表
 * 广义表中放松对表元素的原子限制，容许它们具有其自身结构
 * 特性：①线性结构②多层次结构，有深度③可共享④可递归
 */
public class GenList<T> implements GGenList {
    public GenListNode<T> head;

    public GenList() {
        this.head = new GenListNode<T>();
    }

    public GenList(T[] atoms) {

    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public int length() {
        int i = 0;
        GenListNode<T> p = this.head.next;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    @Override
    public int depth() {
        int max = 1;
        GenListNode<T> p = this.head.next;
        while (p != null) {
            if (p.child != null) {
                int d = p.child.depth();
                if (max <= d) {
                    max = d + 1;
                }
            }
            p = p.next;
        }
        return max;
    }

    @Override
    public GenListNode insert(int i, Object x) {
        if (x == null) {
            return null;                    //不能设置元素为空对象
        }
        GenListNode<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++) {
            p = p.next;
        }
        if (i >= 0 && p != null) {
            p.data = (T) x;                                    //p指向第i个结点
        } else {
            throw new IndexOutOfBoundsException(i + "");    //抛出序号越界异常
        }
        return p;
    }

    @Override
    public GenListNode insert(int i, GenList glist) {
        if (glist == null) {
            return null;
        }
        GenListNode<T> p = this.head;
        for (int j = 0; p != null && j < i; j++) {
            p = p.next;
        }
        p.next = new GenListNode<>(null, glist, p.next);

        return p.next;
    }

    public void append(T x) {
        insert(Integer.MAX_VALUE, x);  //遍历一次
    }

    public void append(GenList<T> glist) {
        insert(Integer.MAX_VALUE, glist);
    }

    @Override
    public void remove(int i) {

    }

    @Override
    public String toString() {
        String str = "(";
        GenListNode<T> p = this.head.next;
        while (p != null) {
            if (p.child == null) {
                str += p.data.toString();
            } else {
                str += p.child.toString();
            }
            if (p.next != null) {
                str += ",";
            }
            p = p.next;

        }
        return str + ")";
    }
}
