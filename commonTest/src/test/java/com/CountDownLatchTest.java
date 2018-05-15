package com;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁 CountDownLatch小测试
 *
 * @author wb-xxb255887
 * @version $$Id: bkpartner-parent, v 0.1 2018/04/05 9:16 wb-xxb255887 Exp $$
 */
public class CountDownLatchTest {
    private static CountDownLatch start = new CountDownLatch(1);
    private static CountDownLatch end = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++) {
            //十个线程并发执行
            //只需20秒结束
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //线程运行到await方法后，都会被阻塞
                        //直到计数器为0，才会继续往下执行
                        start.await();
                        Thread.sleep(20000);
                        System.out.println("get up " + Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //每一个线程执行完后，执行countdown方法会将计数器减1
                        end.countDown();
                    }
                }
            }).start();
        }

        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);
        //所有线程（这里是10个）同时开始并发执行
        start.countDown();
        end.await();
        long endTime = System.currentTimeMillis();
        System.out.println("结束时间：" + (endTime-startTime));
    }
}
