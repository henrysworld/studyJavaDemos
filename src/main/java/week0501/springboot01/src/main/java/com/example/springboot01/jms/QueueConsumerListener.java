package com.example.springboot01.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/5 0:01
 * @Version: 1.0
 */
@Component
public class QueueConsumerListener {
    @JmsListener(destination = "${spring.activemq.queue-name}", containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }
}
