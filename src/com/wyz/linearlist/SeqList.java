package com.wyz.linearlist;

/**
 * 顺序表类设计说明：
 * (1)泛型类SeqList<Integer> list2=new SeqList<Integer>  ()
 * (2) 成员变量必须是私有权限
 * （3）默认构造方法
 * （4）自动扩充容量
 * （5）指定元素序号不正确时的操作处理
 *
 * isEmpty、length、get、set时间复杂度：O(1)
 * remove、insert时间复杂度：O(n)
 *特点：可以随机存取元素；插入和删除操作效率低；当顺序表满时操作效率更低还会占用大量内存空间
 */
public class SeqList<T> implements LList {

    //顺序表类，实现线性表接口
    private Object[] element;//对象数组，私有成员
    private int len;         //顺序表长度

    public SeqList(int size)
    {
        this.element = new Object[size];
        this.len = 0;
    }

    public SeqList(){
        this(64);
    }

    @Override
    public boolean isEmpty()  //判断顺序表是否为空
    {
        return this.len==0;
    }

    @Override
    public int length() //返回顺序表的长度
    {
        return this.len;
    }

    @Override
    public T get(int i) {
        //如果数据长度大于或等于0，并且查询长度小于数组的长度，否则返回null
        if (i>=0 && i<this.len) {
            return (T) this.element[i];
        }
        return null;
    }

    @Override
    public void set(int i, Object x) {
        /**
         *   如果插入的数据为null，直接返回；
         *   如果要替换的数据不再数组范围内，抛出数组下表越界异常；
         *   如果在范围内，替换掉该位置的数据
         */

        if (x==null){
            return;
        }
        if (i>=0 && i<this.len) {
            this.element[i] = x;
        }else {
            throw new IndexOutOfBoundsException(i + "");
        }
    }

    @Override
    public void insert(int i, Object x) {
        /**
         *   插入数据不为空，否则直接返回；
         *   如果数组长度与存储的记录长度一致，则创建一个为当前长度两倍的数组；
         *   如果插入位置在头或者尾部（大于长度位置，小于起始位），则在头部或者尾部进行插入
         *   从数组最后开始，依次复制元素数据到J+1位置，直到i位置，然后i位置进行赋值为x
         */

        if (x==null){
            return;
        }
        if (this.len == element.length){
            Object[]temp = this.element;
            this.element = new Object[temp.length*2];
            for (int j = 0; j < temp.length; j++) {
                this.element[j] = temp[j];
            }
        }

        if (i<0){
            i = 0;
        }
        if (i>this.len){
            i = this.len;
        }
        for (int j = this.len-1; j >=i ; j--) {
            this.element[j+1] = this.element[j];
        }
        this.element[i] = x;
        this.len++;

    }

    @Override
    public void append(Object x) {
        this.insert(this.len,x);
    }

    @Override
    public Object remove(int i) {
        /**
         * 判断删除的位置，如果数组长度为0或位置小于0或位置大于数组长度，直接返回空；
         * 记录i位置数据，依次把J+1位置数据赋值到j位，删除后一位数据元素（置空），长度——1
         */
        if (this.len==0||i<0||i>=this.len){
            return null;
        }
        Object old = this.element[i];
        for (int j = i; j < this.len - 1; j++) {
            this.element[j] = this.element[j+1];
        }
        this.element[len-1] = null;
        this.len--;

        return old;
    }

    @Override
    public void removeAll() {
        this.len = 0;
    }

    @Override
    public Object search(Object key) {
        return null;
    }



    public String toString()
            //打印数组，如果长度为0进行打印，否则打印出（）
    {
        String str="(";
        if (this.len>0) {
            str += this.element[0].toString();
            for (int i = 1; i < this.len; i++)
                str += ", " + this.element[i].toString();
        }
        return str+") ";
    }

    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(obj instanceof SeqList)
        {
            SeqList<T> list=(SeqList<T>)obj;
            if(this.length()==list.length())
            {
                for(int i=0;i<this.length();i++)
                    if(!this.get(i).equals(list.get(i)))
                        return false;
                return true;
            }
        }
        return false;
    }
}
