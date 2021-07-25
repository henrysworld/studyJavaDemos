package com.henry.homework.database.hikari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/25 20:36
 * @Version: 1.0
 */
@Component
public class HikariRunner implements CommandLineRunner {
    @Autowired
    protected JdbcTemplate jdbcTemplate;


    @Override
    public void run(String... args) throws Exception {
        String sql = "select * from users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.stream().forEach(System.out::println);
    }
}
