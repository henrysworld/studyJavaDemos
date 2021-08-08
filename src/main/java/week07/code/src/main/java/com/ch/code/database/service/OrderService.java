package com.ch.code.database.service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/8 14:47
 * @Version: 1.0
 */
public interface OrderService {
    void insertOne(DataSource dataSource, String sql);
    List<Map<String, Object>> query(DataSource dataSource, String sql);
}
