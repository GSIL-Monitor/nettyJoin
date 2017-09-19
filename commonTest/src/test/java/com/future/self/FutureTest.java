package com.future.self;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/19 14:54 xuxinbin Exp $$
 */
public class FutureTest {
    public static void main(String[] args) {
        Client client = new Client();
        DataInter dataInter = client.request("rrr");
        System.out.println("请求完成");
        try {
            //模拟真实项目中其它数据的处理
            Thread.sleep(10000);
            System.out.println("我干我的事");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //获取到真实数据
        System.out.println("数据是：" + dataInter.getResult());
    }
}
