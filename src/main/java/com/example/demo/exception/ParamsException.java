package com.example.demo.exception;

import lombok.NoArgsConstructor;

/**
 * ParamsException
 */
@NoArgsConstructor
public class ParamsException extends Exception {

    private static final long serialVersionUID = 1L;

    // 错误码
    final public static String code = "40001";

    public ParamsException(String message) {
        super(message);
    }

}