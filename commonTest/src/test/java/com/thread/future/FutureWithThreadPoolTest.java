package com.thread.future;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 异步命令框架 future练习
 *
 * 假设该场景：
 *  我现在即想挂机打怪，又想写作业
 *  但是有好多个游戏需要挂机（可以用线程池来实现）
 *
 * @author wb-xxb255887
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/05 22:18 wb-xxb255887 Exp $$
 */
public class FutureWithThreadPoolTest {

    private static int count = 0;
    private static final ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5,new ThreadFactoryBuilder().setNameFormat("GameThread%s").build());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //设置核心线程的超时时间
        executor.setKeepAliveTime(20, TimeUnit.SECONDS);
        //如果核心线程超过aliveTime，那就杀死核心线程
        executor.allowCoreThreadTimeOut(true);
        executor.invokeAll(getTaskList());

        Lunch lunch = new Lunch();
        lunch.eatLunch();
    }

    private static List<Callable<String>> getTaskList() {
        List<Callable<String>> taskList = Lists.newArrayList();
        taskList.add(new Game("王者荣耀"));
        taskList.add(new Game("我的世界"));
        taskList.add(new Game("梦幻西游"));
        taskList.add(new Game("极品飞车"));
        taskList.add(new Game("泡泡堂"));
        taskList.add(new Game("四川麻将"));
        return taskList;
    }

    static class Game implements Callable<String>{

        private String gameName;

        public Game(String gameName) {
            this.gameName = gameName;
        }

        @Override
        public String call() throws Exception {
//            if (count == 0) {
//                throw new IllegalArgumentException("参数有误");
//            }
            Thread.sleep(3000L);
            System.out.println("打完"+gameName);
            return gameName;
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

    static class Lunch {
        private void eatLunch() throws InterruptedException {
            System.out.println("开始吃午饭");
            Thread.sleep(3000L);
            System.out.println("吃完了");
        }
    }
}
