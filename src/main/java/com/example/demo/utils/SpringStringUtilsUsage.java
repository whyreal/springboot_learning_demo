package com.example.demo.utils;

import org.springframework.util.StringUtils;

/**
 * 介绍 org.springframework.util.StringUtils 的使用
 */
public class SpringStringUtilsUsage {

    static public void isEmptyUsage() {
        System.out.println(StringUtils.isEmpty(""));  // true
        System.out.println(StringUtils.isEmpty(null)); // true
        System.out.println(StringUtils.isEmpty("abc")); // false
    }

    public static void main(String[] args) {

        isEmptyUsage();
    }
}