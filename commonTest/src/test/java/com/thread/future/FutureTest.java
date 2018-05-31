package com.thread.future;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 异步命令框架 future练习
 *
 * 假设该场景：
 *  我现在即想挂机打怪，又想写作业
 *
 * @author anthony_xu
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/05 22:18 anthony_xu Exp $$
 */
public class FutureTest {

    private static int count = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> gameCallable = new Game();
        FutureTask gameFutureTask = new FutureTask<String>(gameCallable);
//        System.out.println(gameFutureTask.isCancelled()); //false
//        System.out.println(gameFutureTask.isDone());  //false
        //开始挂机了，与此同时我要去写作业了
        new Thread(gameFutureTask).start();

        //写作业可以是主线程跑，也可以单起一个线程跑，最后都是判断游戏是否打完，gameFutureTask.isDone()
        new Thread(new Homework()).start();

        if (gameFutureTask.isDone()) {
            System.out.println("task is done.");
            System.out.println(gameFutureTask.get());
        }
    }

    static class Game implements Callable<String>{

        @Override
        public String call() throws Exception {
//            if (count == 0) {
//                throw new IllegalArgumentException("参数有误");
//            }
            Thread.sleep(3000L);
            return "挂机打游戏无所不能！";
        }
    }

    static class Homework implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000L);
                System.out.println("写完作业了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
