package com.example.demo.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Data   // 自动生成 getter，setter
@NoArgsConstructor  // 自动生成无参数的构造函数
@AllArgsConstructor  // 自动生成包含所有 field 的构造函数
public class User {

    @NotEmpty
    public String name;

    @Max(100)
    @Min(18)
    public Integer age;

}