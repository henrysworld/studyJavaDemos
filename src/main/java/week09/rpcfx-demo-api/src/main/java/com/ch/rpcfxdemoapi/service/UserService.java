package com.ch.rpcfxdemoapi.service;

import com.ch.rpcfxdemoapi.model.User;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:25
 * @Version: 1.0
 */
public interface UserService {

    User findById(Integer id);
}
