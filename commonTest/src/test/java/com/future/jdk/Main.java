package com.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/19 15:30 xuxinbin Exp $$
 */
public class Main {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new RealDataCollableImpl("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);
        System.out.println("线程已经启动");
        try {
            System.out.println("睡两秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("ａ." + executorService.isShutdown()); //false
            System.out.println("b." + executorService.isTerminated()); //false
            System.out.println("数据" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("c." + executorService.isShutdown()); //false
        System.out.println("d." + executorService.isTerminated()); //false
        executorService.shutdown();
        System.out.println("e." + executorService.isShutdown()); //true
        System.out.println("f." + executorService.isTerminated()); //false
    }
}
