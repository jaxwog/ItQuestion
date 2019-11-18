package com.wyz.stack;

public class Process implements Comparable<Process> {

    private String name;    //进程名
    private int priority;     //优先级

    public Process(String name,int priority){
        this.name = name;
        this.priority = priority;

    }

    @Override
    public String toString() {
        return "("+this.name+","+this.priority+")";
    }

    @Override
    public int compareTo(Process o) {
        return this.priority - o.priority;        //比较两个进程的大小，约定进程排队秩序的规则
    }
}
