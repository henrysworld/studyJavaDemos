package com.ch.rpcfxdemoclient;

import com.ch.rpcfxcore.proxy.RpcByteBuddy;
import com.ch.rpcfxcore.proxy.RpcClient;
import com.ch.rpcfxcore.proxy.RpcClientJdk;
import com.ch.rpcfxdemoapi.model.Order;
import com.ch.rpcfxdemoapi.model.User;
import com.ch.rpcfxdemoapi.service.OrderService;
import com.ch.rpcfxdemoapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RpcfxDemoClientApplication {

    public static void main(String[] args) {
        RpcClient jdk = new RpcClientJdk();
        UserService userService = jdk.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        if (user == null){
            log.info("Client service invoke Error");
            return;
        }
        System.out.println("find user id=1 from server: " + user.getName());

        RpcClient buddy = new RpcByteBuddy();
        OrderService orderService = buddy.create(OrderService.class, "http://localhost:8080/");
        Order order = orderService.findById(1992129);
        if (order == null){
            log.info("Client service invoke Error");
            return;
        }
        System.out.println(String.format("find order name=%s, user=%d",order.getName(),order.getUserId()));

    }

}
