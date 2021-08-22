package com.ch.rpcfxdemoapi.model;

import lombok.Data;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:24
 * @Version: 1.0
 */
@Data
public class Order {
    private Integer id;
    private String name;
    private Integer userId;

    public Order(Integer id, String name, Integer userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }
}
