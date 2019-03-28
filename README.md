# 项目目标

通过代码，介绍一些 springboot API 项目中的最佳实践，包括：

- 参数获取
- 参数校验
- 统一 response 格式
- 自定义错误，及统一错误处理
- 集成测试的书写

# 新建项目

spring 官方提供了一个[网站](https://start.spring.io)，专门用于springboot项目的创建。

本 demo 选择的依赖包括：

- web, Servlet web application with Spring MVC and Tomcat
- jpa, spring data & hibernate
- lombok, 减少模版代码
- devtools， springboot 开发工具
- validationg

# Controller

## 参数获取

> springmvc 提供了多种方式在 controller 中获取参数，通常不需要注入 request 对象。
> request 对象应该只出现在 controller 层，不应该将 request 对象传递到 service 层。

http 传递参数有几种常见的方式：

1. 通过 URL

    这种方式通常用在 restful 风格的 API 中，用来指定目标资源

2. 通过 querysring
3. 通过 http header

    常见于网关于后端通讯时，既不改变原请求，有需要附加一些信息

4. 通过 request body

    POST 请求通过 request body 传递数据
