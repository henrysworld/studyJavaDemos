package com.henry.homework.database.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/25 20:36
 * @Version: 1.0
 */
@Configuration
public class MyHikariConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig("/hikari.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
}
