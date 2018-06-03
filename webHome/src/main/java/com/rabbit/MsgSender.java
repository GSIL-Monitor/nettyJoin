package com.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息 生产者
 *
 * 此处模拟3秒发送一次消息，
 * 可以通过本地rabbit提供对后台管理工具，
 * 查看消息的生产和消费情况，
 * 工具地址：http://localhost:15672，（这是默认的端口）
 * 账号密码默认都是：guest
 *
 * @author anthony_xu
 * @create $ID: MsgSender, v0.1 2018年06月03日 21:04 anthony_xu Exp $
 */
@Component
public class MsgSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        while (true) {
            String context = "hello " + new Date();
            System.out.println("Sender : " + context);
            this.rabbitTemplate.convertAndSend("anthony", context);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
