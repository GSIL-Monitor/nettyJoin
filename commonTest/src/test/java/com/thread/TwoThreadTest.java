package com.thread;

import com.model.Counter;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/14 9:56 xuxinbin Exp $$
 */
public class TwoThreadTest extends Thread{
    protected Counter counter = null;

    public TwoThreadTest(String threadName, Counter counter) {
        super(threadName);
        this.counter = counter;
    }

    public void run() {
        for (int i=0; i<10; i++) {
            counter.add(i);
        }
    }
}
