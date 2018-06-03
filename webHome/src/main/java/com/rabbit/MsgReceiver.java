package com.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息 接收者
 *
 * @author anthony_xu
 * @create $ID: MsgReceiver, v0.1 2018年06月03日 21:06 anthony_xu Exp $
 */
@Component
@RabbitListener(queues = "anthony")
public class MsgReceiver {

    @RabbitHandler
    public void process(String context) {
        System.out.println("Receiver  : " + context);
    }

}
