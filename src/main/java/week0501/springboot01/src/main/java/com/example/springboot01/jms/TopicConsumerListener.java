package com.example.springboot01.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/5 0:01
 * @Version: 1.0
 */

@Component
public class TopicConsumerListener {

    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "topicListener")
    public void readActiveQueue(String message){
        System.out.println("topic接收到：" + message);
    }
}
