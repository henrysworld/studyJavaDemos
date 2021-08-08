package com.ch.code.database.service.impl;

import com.ch.code.database.annotation.ReadAnnotation;
import com.ch.code.database.service.OrderService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/8 14:48
 * @Version: 1.0
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @SneakyThrows
    @Override
    public void insertOne(DataSource dataSource, String sql) {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
        try (Connection conn = dataSource.getConnection(); Statement statement = conn.createStatement()){
            statement.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }



    @SneakyThrows
    @ReadAnnotation
    @Override
    public List<Map<String, Object>> query(DataSource dataSource, String sql) {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Map<String, Object>> entities = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Map<String, Object> data = new HashMap<>();
                data.put("id", resultSet.getLong("id"));
                data.put("name", resultSet.getString("name"));
                data.put("description", resultSet.getString("description"));
                entities.add(data);
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        }

        return null;

    }
}
