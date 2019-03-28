package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Error
 */
@AllArgsConstructor
@Data
public class Error {

    public String code = "";
    public String massage = "";
}