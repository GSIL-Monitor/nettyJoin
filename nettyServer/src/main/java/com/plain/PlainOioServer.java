package com.plain;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import io.netty.util.CharsetUtil;

/**
 * 未使用netty的阻塞网络编程
 *
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/8/8 9:05 xuxinbin Exp $$
 */
public class PlainOioServer {

    private Logger logger = Logger.getLogger("PlainOioServer");

    public void serve(int port) throws IOException {
        //将服务器绑定到指定端口
        final ServerSocket socket = new ServerSocket(port);

        try {
            for (;;) {
                //接受链接
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                new Thread(new Runnable() {
                    @Override public void run() {
                        OutputStream outputStream;
                        try {
                            outputStream = clientSocket.getOutputStream();
                            //将消息写给已连接的客户端
                            outputStream.write("Hi!\r\n".getBytes(CharsetUtil.UTF_8));
                            outputStream.flush();
                            //关闭连接
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
