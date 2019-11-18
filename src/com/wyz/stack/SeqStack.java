package com.wyz.stack;

/**
 * 顺序栈类，实现栈接口
 */
public class SeqStack<T> implements SStack<T> {

    private Object[] element;                 //存储栈数据元素的数组
    private int top;                          //栈顶元素下标

    public SeqStack(int size){               //构造容量为size的空栈
        element = new Object[Math.abs(size)];
        this.top = -1;
    }

    public SeqStack(){                     //构造默认容量的空栈
        this(64);
    }

    @Override
    public boolean isEmpty() {            //判断栈是否空，若空返回true
        return this.top == -1;
    }

    @Override
    public void push(T x) {
        if (x==null){
            return;                        //空对象不能入栈
        }
        if (this.top==this.element.length-1){    //如果栈满，则从新申请栈空间
            Object []temp = this.element;
            this.element = new Object[this.element.length*2];
            for (int i = 0; i < temp.length; i++) {
                this.element[i] = temp[i];           //复制数组元素，O(n)
            }
        }
        this.top++;
        this.element[this.top] = x ;

    }

    @Override
    public T pop() {                         //出栈，返回栈顶元素，若栈空返回null
        return this.top==-1 ? null : (T) this.element[this.top--];
    }

    @Override
    public T get() {                         //取栈顶元素，未出栈，若栈空返回null
        return this.top==-1 ? null : (T)this.element[this.top];
    }


    public String toString() //返回栈所有元素的描述字符串，形式为“(,)”，算法同顺序表,时间复杂度O(n)
    {
        String str="(";
        if (this.top!=-1) {
            str += this.element[this.top].toString();
        }
        for (int i=this.top-1; i>=0; i--) {
            str += ", " + this.element[i].toString();
        }
        return str+") ";
    }
}
