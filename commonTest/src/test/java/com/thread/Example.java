package com.thread;

import com.model.Counter;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/14 10:01 xuxinbin Exp $$
 */
public class Example {
    public static void main(String[] args) {
        testOneInstance();

        testTwoInstance();
    }

    private static void testTwoInstance() {
        for (int i=0; i<1000; i++) {
            Counter counterA = new Counter();
            Counter counterB = new Counter();
            Thread threadA = new TwoThreadTest("A", counterA);
            Thread threadB = new TwoThreadTest("B", counterB);

            threadA.start();
            threadB.start();

            if (!threadA.isAlive() && !threadB.isAlive()) {
                if (counterA.getCount() != 45 && counterB.getCount() != 45) {
                    System.out.println("出错啦！！！！！！！！！");
                }
            }
        }
    }

    private static void testOneInstance() {
        for (int i=0; i<1000; i++) {
            Counter counter = new Counter();
            Thread threadA = new TwoThreadTest("A", counter);
            Thread threadB = new TwoThreadTest("B", counter);

            threadA.start();
            threadB.start();

            if (!threadA.isAlive() && !threadB.isAlive()) {
                if (counter.getCount() != 90) {
                    System.out.println("出错啦！！！！！！！！！");
                }
            }
        }
    }
}
