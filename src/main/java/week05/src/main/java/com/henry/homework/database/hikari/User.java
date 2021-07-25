package com.henry.homework.database.hikari;

import lombok.Data;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/25 20:35
 * @Version: 1.0
 */
@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private String phoneNumber;
    private Long money;
}
