package com.performanceTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author wb-xxb255887
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/06 21:51 wb-xxb255887 Exp $$
 */
public class PressureTest {

    private static CountDownLatch start = new CountDownLatch(1);
    private static CountDownLatch end = new CountDownLatch(500);

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i=0; i<500; i++) {
            new Thread(new PressureTask()).start();
        }

        long startTime = System.currentTimeMillis();
        start.countDown();
        end.await();
        System.out.println(String.format("耗时：%s",
                System.currentTimeMillis() - startTime));
    }

    static class PressureTask implements Runnable {

        @Override
        public void run() {
            try {
                start.await();
                CloseableHttpClient httpClient = HttpClients.createDefault();
                //创建一个GET对象
                HttpGet get =new HttpGet("http://bkpartner2.dev.mayibank.net:9090/test/test500Qps.json?pdCode=01021000100000000260");
                //执行请求
                CloseableHttpResponse response =httpClient.execute(get);
                //取响应的结果
                int statusCode =response.getStatusLine().getStatusCode();
//                System.out.println(statusCode);
                HttpEntity entity =response.getEntity();
                String string = EntityUtils.toString(entity,"utf-8");
//                System.out.println(string);
                //关闭httpclient
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                end.countDown();
            }
        }
    }
}
