package com.rabbitmq;

import com.rabbit.MsgSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * rabbit消息队列测试
 *
 * @author anthony_xu
 * @create $ID: RabbitMqHelloTest, v0.1 2018年06月03日 21:09 anthony_xu Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private MsgSender msgSender;

    @Test
    public void hello() throws Exception {
        msgSender.send();
    }

}
