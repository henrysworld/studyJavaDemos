package com.cn.code.mappers;

import com.cn.code.models.Order;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.Or;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/11 23:53
 * @Version: 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
@MapperScan("com.cn.code.mappers")
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    @Transactional
    public void test(){

        System.out.println(orderMapper.toString());
        orderMapper.insertOne(new Order("test1", 1L, 1L, 100L, "test 1 detail", 1));
        orderMapper.insertOne(new Order("test2", 2L, 2L, 200L, "test 2 detail", 1));

//        Map<String, Object> condition = new HashMap<>(1);
//        condition.put("user_id", 1L);
//
//        List<Map<String, Object>> orderQuery = orderMapper.query(condition);
//        for (Map item : orderQuery){
//            System.out.println(item.toString());
//        }

    }

}
