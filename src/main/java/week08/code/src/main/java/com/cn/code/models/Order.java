package com.cn.code.models;

import lombok.Data;

import java.util.Date;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/11 23:29
 * @Version: 1.0
 */
@Data
public class Order {
    private Long id;
    private String name;
    private Long commodity_id;
    private Long user_id;
    private Long price;
    private String details;
    private Integer status;
    private Long create_time;
    private Long update_time;
    private Integer del;

    public Order(String name, Long commodity_id, Long user_id, Long price, String details, Integer status) {
        this.name = name;
        this.commodity_id = commodity_id;
        this.user_id = user_id;
        this.price = price;
        this.details = details;
        this.status = status;
    }

}
