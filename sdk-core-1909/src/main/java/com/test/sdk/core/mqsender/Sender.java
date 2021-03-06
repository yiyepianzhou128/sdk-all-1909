package com.test.sdk.core.mqsender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 徒有琴
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;//springboot封装的对象，用于操作MQ
    public void send(String message){
        amqpTemplate.convertAndSend("login_server_log",message);//发消息
    }
}
