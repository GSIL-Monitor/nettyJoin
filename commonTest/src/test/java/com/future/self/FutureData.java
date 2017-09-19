package com.future.self;

/**
 * future模式
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/19 14:41 xuxinbin Exp $$
 */
public class FutureData implements DataInter {

    public RealData realData;

    private boolean isReady = false;

    @Override
    public String getResult() {
        while (!isReady) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return ;
        }

        this.realData = realData;
        isReady = true;
        this.notifyAll();
    }
}
