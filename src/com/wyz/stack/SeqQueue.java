package com.wyz.stack;

/**
 * 顺序循环队列
 *（1） 队头、队尾元素下标按照循环规律变化。front=(front+1) % length;rear=(rear+1) % length;
 * （2）约定rear含义及队列空条件。约定rear是下一个入队元素位置。队列空条件是：rear=＝front；
 * （3）约定队列满条件。约定队列满条件是队列中仍有一个空位置，即front＝=(rear+1) % length;
 * toString时间复杂度为O(n)，其它方法为O(1)
 */
public class SeqQueue<T> implements QQueue<T> {
    private Object[]element;                     //存储队列数据元素的数组
    private int front,rear;                      //front、rear分别为队列头尾下标

    public SeqQueue(int length){                 //构造容量为length的空队列，最小值为64
        if (length<64){
            length = 64;
        }
        this.element = new Object[Math.abs(length)];
        this.front = this.rear = 0;
    }

    public SeqQueue(){
        this(64);
    }


    @Override
    public boolean isEmpty() {               //判断队列是否空，若空返回true
        return this.front==this.rear;
    }

    @Override
    public void enqueue(T x) {
        if (x==null){
            return;
        }
        if (this.front==(this.rear+1)%this.element.length){            //如果出与入的坐标一致，说明队列已满
            Object [] temp = this.element;
            this.element = new Object[this.element.length*2];
            int j = 0;
            for (int i = this.front; i!=this.rear;i= (i+1)%temp.length){    //按照队列元素次序复制数组元素
                this.element[j++] = temp[i];
            }
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1) % this.element.length;


    }

    @Override
    public T dequeue() {                 //出队，返回队头元素，如果队列为空返回null
        if (isEmpty()){
            return null;
        }
        T temp = (T) this.element[front];
        this.front = (this.front+1)%this.element.length;
        return temp;
    }

    @Override
    public String toString() {
        String str="(";
        if (!isEmpty())
        {
            str += this.element[this.front].toString();
            int i=(this.front+1) % this.element.length;
            while(i!=this.rear)
            {
                str += ", "+this.element[i].toString();
                i=(i+1) % this.element.length;
            }
        }
        return str+")";
    }
}
