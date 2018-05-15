package com.thread.blockingqueue;

import com.google.common.collect.Queues;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 学习阻塞队列和线程池
 *
 * @author wb-xxb255887
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/06 0:39 wb-xxb255887 Exp $$
 */
public class BlockingQueueAndThreadPool {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
            20, TimeUnit.SECONDS, Queues.<Runnable>newLinkedBlockingQueue());

    public static void main(String[] args) {
//        executor.allowCoreThreadTimeOut(true);
        for ( int i = 0; i < 20; i++) {
            executor.execute( new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println( this.hashCode());
//                        System.out.println( this.hashCode()/1000);
//                        for ( int j = 0; j < 10; j++) {
//                            Thread.sleep(this.hashCode()%2);
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String. format("thread %d finished", this.hashCode()));
                }
            });
        }
//        executor.shutdown();
//        executor.shutdownNow();
    }
}
