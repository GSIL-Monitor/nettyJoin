package com.future.jdk;

import java.util.concurrent.Callable;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/9/19 15:28 xuxinbin Exp $$
 */
public class RealDataCollableImpl implements Callable<String>{

    private String param;

    public RealDataCollableImpl(String param) {
        this.param = param;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        //真实业务逻辑
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<10; i++) {
            sb.append(i + param);
            try {
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
