package com.ch.rpcfxcore.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:48
 * @Version: 1.0
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException{
    private String message;

    public CustomException(String custom_exception){
        super();
    }

    public CustomException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
