package com.ch.rpcfxdemoapi.model;

import lombok.Data;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:24
 * @Version: 1.0
 */
@Data
public class User {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
