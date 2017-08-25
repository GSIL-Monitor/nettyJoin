package com.thread;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/8/24 16:52 xuxinbin Exp $$
 */
public class ThreadTest {

    public static void main(String[] args) {
        //outputThreadName();
        //outputDivide();
        //outputThreadName1();
        outputThreadName2();
    }

    private static void outputThreadName2() {
        System.out.println(Thread.currentThread().getName());
        for (int i=0; i<10; i++) {
            new Thread(new Runnable() {
                @Override public void run() {
                    System.out.println(System.nanoTime());
                }
            }).start();
        }
    }

    private static void outputThreadName() {
        System.out.println(Thread.currentThread().getName());
        for (int i=0; i<10; i++) {
            new Thread(""+ i) {
                public void run() {
                    System.out.println("Thread " + getName());
                }
            }.start();
        }
    }

    private static void outputThreadName1() {
        Thread thread = new Thread(new MyRunner(), "我是thread名字");
        thread.start();
        System.out.println(thread.getName());
    }

    static class MyRunner implements Runnable{

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override public void run() {
            System.out.println("我是run方法");
        }
    }

    public static void outputDivide() {
        System.out.println("==================================================");
    }
}
