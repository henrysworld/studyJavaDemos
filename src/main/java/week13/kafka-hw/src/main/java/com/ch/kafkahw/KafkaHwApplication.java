package com.ch.kafkahw;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaHwApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaHwApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String servers = "localhost:9092,localhost:9093,localhost:9094";
        String topic = "TestTopic";
        String message = "test";

        KafkaProducer<String, String> producer = KafkaUtil.createProducer(servers);
        KafkaUtil.send(producer, topic, message);

        KafkaConsumer<String, String> consumer = KafkaUtil.createConsumer(servers, topic);
        KafkaUtil.readMessage(consumer, 100);
    }
}
