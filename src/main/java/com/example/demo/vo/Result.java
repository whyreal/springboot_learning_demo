package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义一个统一的返回格式
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {

    public Object data = null;
    public Error err = null;
}