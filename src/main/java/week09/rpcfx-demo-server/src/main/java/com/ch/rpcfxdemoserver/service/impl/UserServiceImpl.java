package com.ch.rpcfxdemoserver.service.impl;

import com.ch.rpcfxdemoapi.model.User;
import com.ch.rpcfxdemoapi.service.UserService;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:36
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC");
    }
}
