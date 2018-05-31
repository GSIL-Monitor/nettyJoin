package com.thread.future;

/**
 * 在没有future的场景下，也不使用多线程，
 * 串行执行非常耗时
 *
 * 假设该场景：
 *  我现在即想挂机打怪，又想写作业
 *
 * @author anthony_xu
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/05 22:41 anthony_xu Exp $$
 */
public class NoFutureTest {

    public static void main(String[] args) throws InterruptedException {
        long startT = System.currentTimeMillis();

        //开始玩游戏
        PlayGame game = new PlayGame();
        game.playGame();

        FinishHomework homework = new FinishHomework();
        homework.finishHomework();

        long endT = System.currentTimeMillis();

        System.out.println(String.format("耗时：%s", endT - startT));
    }

    static class PlayGame{
        public void playGame() throws InterruptedException {
            Thread.sleep(3000L);
        }
    }

    static class FinishHomework{
        public void finishHomework() throws InterruptedException {
            Thread.sleep(3000L);
        }
    }
}
