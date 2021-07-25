package com.henry.homework.database.hikari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/25 20:08
 * @Version: 1.0
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.henry.homework.database.hikari")
public class HikariApplication {
    public static void main(String[] args) {
        SpringApplication.run(HikariApplication.class, args);
    }
}
