package com.ch.code.database.mapper;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/8 11:59
 * @Version: 1.0
 */
@Entity
@Data
public class OrderEntity {

    @Id @GeneratedValue
    private Long id;
    private Long user_id;
    private String commodities;
    private int status;
    private String deliver_status;
    private Long total_price;
    private Long create_time;
    private Long update_time;

    public OrderEntity(long user_id, String commodities, long total_price) {
        this.user_id = user_id;
        this.commodities = commodities;
        this.status = 0;
        this.deliver_status = "{}";
        this.total_price = total_price;
        this.create_time = Long.valueOf(String.valueOf(System.currentTimeMillis() / 1000));
        this.update_time = create_time;
    }

    public OrderEntity() {

    }
}
