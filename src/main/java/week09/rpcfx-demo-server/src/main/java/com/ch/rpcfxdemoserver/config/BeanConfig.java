package com.ch.rpcfxdemoserver.config;

import com.ch.rpcfxdemoapi.service.OrderService;
import com.ch.rpcfxdemoapi.service.UserService;
import com.ch.rpcfxdemoserver.service.impl.OrderServiceImpl;
import com.ch.rpcfxdemoserver.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:36
 * @Version: 1.0
 */
@Configuration
public class BeanConfig {

    @Bean("com.ch.rpcfxdemoapi.service.UserService")
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean("com.ch.rpcfxdemoapi.service.OrderService")
    public OrderService orderService(){
        return new OrderServiceImpl();
    }
}
