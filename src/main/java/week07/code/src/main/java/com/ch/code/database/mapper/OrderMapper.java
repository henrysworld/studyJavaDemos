package com.ch.code.database.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/8 12:05
 * @Version: 1.0
 */
@Repository
public interface OrderMapper {
    void insertOne(OrderEntity orderEntity);
    void insertMany(List<OrderEntity> orders);
    void delete(Long id);
    void update(OrderEntity orderEntity);
    List<Map<String, Object>> query(Map<String, Object> condition);

}
