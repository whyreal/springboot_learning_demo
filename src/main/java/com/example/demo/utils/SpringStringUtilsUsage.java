package com.example.demo.utils;

import org.springframework.util.StringUtils;

/**
 * SpringStringUtilsUsage
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