package com.ch.rpcfxdemoserver.service.impl;

import com.ch.rpcfxcore.exception.CustomException;
import com.ch.rpcfxdemoapi.model.Order;
import com.ch.rpcfxdemoapi.service.OrderService;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:36
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public Order findById(Integer id) {
        return new Order(1, "RPC", 1);
    }

    @Override
    public Order findError() {
        throw new CustomException("Custom exception");
    }
}
