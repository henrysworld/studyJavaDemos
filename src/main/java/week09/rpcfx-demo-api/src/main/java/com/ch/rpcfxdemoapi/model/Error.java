package com.ch.rpcfxdemoapi.model;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 15:24
 * @Version: 1.0
 */
public class Error {

    private Integer status;
    private String message;

    public Error(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
