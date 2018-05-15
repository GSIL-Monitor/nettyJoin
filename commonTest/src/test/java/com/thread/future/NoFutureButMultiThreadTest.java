package com.thread.future;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在没有future的场景下，
 * 但使用多线程
 *
 * 假设该场景：
 *  我现在即想挂机打怪，又想写作业
 *
 * @author wb-xxb255887
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/05 22:41 wb-xxb255887 Exp $$
 */
public class NoFutureButMultiThreadTest {

    //在该场景中，可能存在两个线程同时进行+1操作，导致最终结果还是1
    private static int unSafeCount = 0;

    //确保原子性
    private static AtomicInteger safeCount = new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        long startT = System.currentTimeMillis();

        //开始玩游戏
        Game game = new Game();
        new Thread(game).start();

        Homework homework = new Homework();
        new Thread(homework).start();

        while (true) {
//            Thread.sleep(1000L);
//            System.out.println("main unsafe=" + unSafeCount);
//            System.out.println("main safe=" + safeCount);
            if (unSafeCount == 2) {
                long endT = System.currentTimeMillis();
                System.out.println(String.format("不安全的耗时：%s", endT - startT));
                break;
            }

            if (safeCount.get() == 12) {
                long endT = System.currentTimeMillis();
                System.out.println(String.format("安全的耗时：%s", endT - startT));
                break;
            }
        }
    }

    static class Game implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000L);
//                ++unSafeCount;
//                System.out.println("game unsafe=" + unSafeCount);
                safeCount.incrementAndGet();
                System.out.println("game safe=" + safeCount.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Homework implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000L);
//                ++unSafeCount;
//                System.out.println("homework unsafe=" + unSafeCount);
                safeCount.incrementAndGet();
                System.out.println("homework save=" + safeCount.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
