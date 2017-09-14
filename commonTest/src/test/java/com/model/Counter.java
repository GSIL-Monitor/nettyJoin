package com.model;

/**
 * 用于测试多线程同步的计数器
 *
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/14 9:58 xuxinbin Exp $$
 */
public class Counter {

    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
        //System.out.println(Thread.currentThread().getName() + "=====" + count);
    }

    public long getCount() {
        return count;
    }
}
