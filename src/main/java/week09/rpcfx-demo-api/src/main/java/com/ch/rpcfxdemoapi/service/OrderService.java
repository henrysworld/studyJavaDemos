package com.ch.rpcfxdemoapi.service;

import com.ch.rpcfxdemoapi.model.Order;
import org.apache.tools.ant.taskdefs.condition.Or;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:25
 * @Version: 1.0
 */
public interface OrderService {

    Order findById(Integer id);

    Order findError();

}
