package com.wyz.array;

import com.wyz.linearlist.SortedSinglyLinkedList;

import java.util.concurrent.ForkJoinPool;

/**
 * 十字链表   将行的单链表和列的单链表结合起来存储稀疏矩阵
 * 十字链表将各行的非零元素和各列的非零元素分别链接在一起。
 * 结点由5部分组成：行号、列号、元素值、行的后继结点链、列的后继结点链
 * 行指针与列指针数组存放单链表的行头指针与列头指针
 */
public class CrossLinkedSparseMatrix {

    private int rows,columns;                     //矩阵的行数和列数
    private Element[] elems;
    private CrossNode rowheads[],columnheads[];        //行与列的指针数组，元素类型是十字链表结点

    public CrossLinkedSparseMatrix(int rows,int columns){
        if (rows<=0||columns<=0){
            throw new IllegalArgumentException("矩阵行/列非正数");
        }

        this.rows = rows;
        this.columns = columns;
        this.rowheads = new CrossNode[this.rows];
        this.columnheads = new CrossNode[this.columns];

    }

    public CrossLinkedSparseMatrix(int rows,int columns,Element []elems){
        this(rows,columns);
        this.elems = elems;
        for (int i = 0; i < this.elems.length; i++) {      //按照行主序插入一个元素的三元组
            this.set(elems[i]);
        }
    }

    public int get(int i,int j){
        if (i<0 || i>=rows || j<0 || j>=columns){
            throw new IndexOutOfBoundsException("矩阵元素的行/列下标越界");
        }
        CrossNode p = this.rowheads[i];       //获得第i行单链表
        while (p!=null){
            if (p.data.column==j){
                return p.data.value;         //查找到结点，返回矩阵元素
            }
            p = p.right;
        }
        return 0;
    }

    public void set(Element elem){                   //以三元组设置矩阵
        this.set(elem.row,elem.column,elem.value);
    }

    public void set(int row,int column,int value){
        if (value==0){
            return;
        }
        if (row>=this.rows ||column>=this.columns){
            throw new IllegalArgumentException("三元组的行或列号越界");
        }
        //在第row条单链表中查找指定三元组，或更改，或在行、列单链表中插入三元组结点
        Element elem = new Element(row,column,value);
        CrossNode rhead = this.rowheads[row];      //rhead指向第row行单链表的第一个结点
        if (rhead==null || rhead.data.column>column){           //空表插入或者头插入
            this.rowheads[row] = new CrossNode(elem,rhead,null);
            insertColumnHeads(this.rowheads[row]);
            return;
        }
        CrossNode front = null, p = rhead;
        while (p!=null && p.data.column<=column){          //在排序单链表中顺序查找
            if (p.data.column==column){                   //查找到，更改矩阵元素
                p.data.value = value;
                return;
            }
            front = p;            //front是p结点的前驱
            p = p.right;
        }

        front.right = new CrossNode(elem,p,null);     //在front之后插入三元组结点，中间或者尾插入
        insertColumnHeads(front.right);                       //将该结点插入到列的单链表

    }

    private void insertColumnHeads(CrossNode node) {     //插入node结点到相应的列单链表中
        Element elem = node.data;
        CrossNode chead = this.columnheads[elem.column];       //获得该列的单链表
        if (chead==null || chead.data.row>elem.row){           //头插入或者空链表插入
            this.columnheads[elem.column] = node;
            if (chead!=null){
                node.down = chead.down;
            }
        }else {
            CrossNode front = chead,p = front.down;           //front是p的前驱结点
            while (p!=null && p.data.row<=elem.row){
                front = p;
                p = p.down;
            }
            front.down = node;                 //将弄得结点插入在front之后，中间或者尾插入
            node.down = p;
        }

    }

    public void add(CrossLinkedSparseMatrix smat){
        if (this.rows!=smat.rows||this.columns!=smat.columns){
            throw new IllegalArgumentException("两个矩阵阶数不同，不能相加");
        }
        for (int i = 0; i < this.rows; i++) {
            CrossNode rhead = this.rowheads[i];      //获得当前矩阵第i行单链表
            CrossNode q = smat.rowheads[i];         //获得参数矩阵第i行单链表
            if (q==null){
                continue;
            }

            if (rhead==null||rhead.data.column>q.data.column){
                rhead = new CrossNode(new Element(q.data),rhead,null);  //创建结点，复制元素
                this.rowheads[i] = rhead;
                insertColumnHeads(rhead);
                q = q.right;

            }

            CrossNode front = null,p = rhead;                //中间或者尾插入
            while (p!=null&&q!=null){
                if (p.data.column==q.data.column){
                    p.data.value +=q.data.value;
                    if (p.data.value==0){
                        if (front==null){
                            this.rowheads[i] = p.right;
                            removeColumnHeads(p);               //在相应列的单链表中删除node结点
                            p = p.right;
                        }else {                                 //相加后元素不需要存储，删除p界定啊
                            front.right = p.right;
                            removeColumnHeads(p);
                            p = front.right;
                        }
                    }else {
                        front = p;
                        p = front.right;
                    }
                    q = q.right;

                }else if (p.data.column< q.data.column){
                    front = p;
                    p = p.right;                             // 当前矩阵元素值小，p向后移动，q不动
                }else {                                       //复制q结点并插入到front结点之后，复制元素
                    front.right = new CrossNode(new Element(q.data),p,null);
                    q =q.right;
                    insertColumnHeads(front.right);
                }
            }

            while (q!=null){            //将smat矩阵单链表中剩余结点复制并插入到当前链表尾
                front.right = new CrossNode(new Element(q.data),null,null);
                insertColumnHeads(front.right);
                front = front.right;
                q = q.right;
            }
        }
    }

    private void removeColumnHeads(CrossNode node) {        //在相应的单链表中删除node结点
        Element elem = node.data;
        CrossNode chead = this.columnheads[elem.column];              //获得column列单链表
        if (chead.data.row==elem.row){                        //头删除
            this.columnheads[elem.column] = node.down;          //删除node结点
        }else{                                                //中间或者尾删除
            CrossNode front = chead, p=front.down;             //front是p的前驱结点
            while (p!=null &&p.data.row<elem.row){                //在排序单链表中顺序下载
                front = p;
                p = p.down;
            }
            if (p!=null&&p.data.row == elem.row){              //p为查找到的结点，待删除
                front.down = node.down;                    //删除front之后的node结点，中间或尾插入
            }
        }
    }


    @Override
    public String toString() {
        String str = "三元组的单链表：\n";
//        for (int i = 0; i < this.elems.length; i++) {
//            str +=this.elems[i].toString()+"  ";
//        }

        str+="稀疏矩阵"+this.getClass().getName()+" ("+rows+"x"+columns+"):\n";

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.get(i,j)==0){
                    str += String.format("%4d",0);
                }else {
                    str += String.format("%4d",this.get(i,j));
                }
            }
            str+="\n";
        }




        return str;
    }
}
