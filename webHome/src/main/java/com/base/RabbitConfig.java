package com.base;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列配置
 *
 * @author anthony_xu
 * @create $ID: RabbitConfig, v0.1 2018年06月03日 21:00 anthony_xu Exp $
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("anthony");
    }
}
