package com.ch.jmsactivemq;

import com.ch.jmsactivemq.jms.JmsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJms
@Slf4j
public class JmsActivemqApplication  implements ApplicationRunner {

    @Autowired
    private JmsProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(JmsActivemqApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String topic = "activeTest";
        Map<String, String> message = new HashMap<>(1);
        message.put("test", "test");
        log.info("send message to topic " + topic + " :: " + message);
        producer.sendMessage(topic, message);
    }
}
