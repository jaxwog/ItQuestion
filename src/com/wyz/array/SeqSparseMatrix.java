package com.wyz.array;

import com.wyz.linearlist.SeqList;

/**
 * 类     顺序表存储稀疏矩阵
 *
 * 一个稀疏矩阵可由其非零元素的三元组线性表及行列数唯一确定
 * 稀疏矩阵的压缩存储问题转换为一个三元组线性表的存储问题。
 * 三元组线性表可以采用顺序存储或链式存储实现。
 * rows,columns表示是矩阵的行、列号，list是顺序表元素为Element
 */
public class SeqSparseMatrix {

    int rows,columns;

    private SeqList<Element> list;

    public SeqSparseMatrix(int rows,int columns){
        if (rows<=0 && columns<=0){
            throw new IllegalArgumentException("矩阵行/列数为非正数，且不能为0");
        }
        this.columns = columns;
        this.rows = rows;
        list = new SeqList<Element>();
    }

    /**
     * 矩阵Amxn
     * @param rows   矩阵行数m
     * @param columns   矩阵列数n
     * @param elems   三元数组提供的矩阵初始值
     */
    public SeqSparseMatrix(int rows,int columns,Element []elems){
        this(rows,columns);
        for (int i = 0; i < elems.length; i++) {      //按照行主序插入一个元素的三元组
            this.set(elems[i]);
        }

    }

    public int get(int i,int j){
        if (i>=rows ||i<0 || j<0 || j>=columns){
            throw new IndexOutOfBoundsException("矩阵元素的行/列号越界");
        }
        Element item = new Element(i,j,0);
        int k = 0;
        Element temp = this.list.get(k);

        while (k<this.list.length() && item.compareTo(temp)>=0){     //item对象大于temp对象

            if (item.compareTo(temp)==0){
                return temp.value;
            }
            k++;
            temp = this.list.get(k);
        }
        return 0;
    }

    public void set(Element elems){
         this.set(elems.row,elems.column,elems.value);
    }

    public void set(int row,int column,int value){
        if (value==0){
            return;
        }
        if (row>=this.rows || column>=this.columns){
            throw new IndexOutOfBoundsException("三元组的行/列序号越界");
        }
        Element item = new Element(row,column,value);
        int i = 0;
        while (i<this.list.length()){
            Element temp = this.list.get(i);
            if (item.compareTo(temp)==0){         //如果三元链表中存在该元素，则更改该位置矩阵元素
                this.list.set(i,item);
                return;
            }
            if (item.compareTo(temp)>=0){        //当item较大时，向后走
                i++;
            }else {
                break;
            }
        }
        this.list.insert(i,item);      //插入item对象作为顺序表第i个元素

    }

    public SeqSparseMatrix plus(SeqSparseMatrix smat){
        if (this.rows!=smat.rows && this.columns!=smat.columns){
            throw new IllegalArgumentException("两个矩阵阶数不同，不能相加");
        }

        SeqSparseMatrix smatC = new SeqSparseMatrix(this.rows,this.columns);
        int i = 0,j = 0;

        while (i<this.list.length() && j<smat.list.length()){
            Element smatA = this.list.get(i);
            Element smatB = smat.list.get(j);

            if (smatA.compareTo(smatB)==0){
                if (smatA.value+smatB.value!=0){
                    smatC.list.append(new Element(smatA.row,smatA.column,smatA.value+smatB.value));
                }
                i++;
                j++;
            }else if (smatA.compareTo(smatB)<0){
                smatC.list.append(new Element(smatA));
                i++;
            }else {
                smatC.list.append(new Element(smatB));
                j++;
            }

        }

        while (i<this.list.length()){
            smatC.list.append(new Element(this.list.get(i++)));
        }

        while (j<smat.list.length()){
            smatC.list.append(new Element(smat.list.get(j++)));
        }

        return smatC;
    }


    @Override
    public String toString() {
        String str = "三元组顺序表:"+this.list.toString()+"\n";
        str += "稀疏矩阵"+this.getClass().getName()+" ("+rows+"x"+columns+") : \n";
        int k = 0;
        Element temp = this.list.get(k++);       //返回第k个元素，若k指定序号无效则返回null
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (temp!=null && i==temp.row && j==temp.column){
                    str +=String.format("%4d",temp.value);
                    temp = this.list.get(k++);
                }else {
                    str += String.format("%4d",0);
                }
            }
            str +="\n";
        }

        return str;
    }
}
