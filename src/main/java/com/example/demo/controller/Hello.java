package com.example.demo.controller;

import javax.validation.Valid;

import com.example.demo.vo.Result;
import com.example.demo.vo.User;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 相当于：
 *  @ResponseBody 将 controller 的返回值转换成 json 返回
 *  @Controller
 */
@RestController
@RequestMapping(path = "/demo")
public class Hello {

    /**
     * 从 URI 获取参数
     * 
     * http://localhost:8080/demo/path/whyreal/100
     */
    @GetMapping(path = "/path/{name}/{age}")
    public Result path(@PathVariable(value = "name") String name,
                           @PathVariable(value = "age") Integer age) {
        return new Result(new User(name, age), null);
    }

    /**
     * 从 querystring 获取参数
     * 
     * http://localhost:8080/demo/querystring?name=whyreal&age=100
     * 
     * @RequestParam 是可选的，会被默认添加到 controller 的参数上。例如 age 就没加 @RequestParam
     * 但是依然可以正常获到参数
     * 
     * @RequestParam 可以设定默认值
     */
    @GetMapping(path = "/querystring")
    public Result querySting(@RequestParam(name = "name", defaultValue = "aaa") String name, Integer age) {
        return new Result(new User(name, age), null);
    }

    /**
     * 如果参数比较多，可以使用 pojo 对象获取参数
     * 
     */
    @RequestMapping(path = "/querystringpojo")
    public Result queryStingPOJO(@Valid User user) throws Exception {
        return new Result(user, null);
    }

    /**
     * 从 request body 获取参数
     * 
     *  POST http://localhost:8080/demo/post HTTP/1.1
     *  content-type: application/json
     *
     *  {
     *      "name": "whyreal",
     *      "age": 100
     *  }
     */
    @PostMapping(path = "/postpojo")
    public Result requestBodyPOJO(@Valid @RequestBody User user, BindingResult br) throws Exception {
        return new Result(user, null);
    }

    /**
     * 从 http header 获取参数
     */
    @GetMapping(path = "/header")
    public Result header(@RequestHeader String name, @RequestHeader Integer age) {
        return new Result(new User(name, age), null);
    }


    /**
     * 从 cookie 获取参数
     */
    @GetMapping(path = "/cookie")
    public Result cookie(@CookieValue String name, @CookieValue Integer age) {
        return new Result(new User(name, age), null);
    }
}