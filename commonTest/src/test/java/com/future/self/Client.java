package com.future.self;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/19 14:51 xuxinbin Exp $$
 */
public class Client {

    //请求数据的模式
    public DataInter request(final String queryStr) {
        final FutureData futureData = new FutureData();

        //构造数据
        new Thread(new Runnable() {
            @Override public void run() {
                RealData realData = new RealData();
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }
}
