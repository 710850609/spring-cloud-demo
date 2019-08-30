# spring-cloud-demo
Spring Cloud示例

# 一、项目模块说明

- [spring-cloud-producer](spring-cloud-producer) : 
- [spring-cloud-consumer](spring-cloud-consumer) :
- [spring-cloud-eureka-server](spring-cloud-eureka-server) :



# 二、搭建过程遇到的问题
## 1、 Feign定义远程接口传递多个参数
### 1.1、 GET请求、DELETE请求
- a、使用`Map<String, Object>`请教参数封装
- b、使用`@RequestParam`对单个参数key进行指定
- c、不能直接使用自定义Java对象进行请求，会写入请求体
### 1.2、 POST请求、PUT请求
使用`@RequestBody`对声明请求体参数

## 2、Feign自定义Encoder
###

## 3、Actuator变更
从spring boot 2.x版本开始，actuator相关的一些配置已经修改过，不再适应spring boot1.x版本
默认的访问路径由原来的 /** ，修改为 /actuator/** 。
其他配置参考 https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/

## 4、feign默认关闭hystrix支持
从spring cloud 2.x版本开始，feign默认关闭hystrix的支持。
需要在配置文件加入 `feign.hystrix.enabled=true` ，作为支持开关

## 5、hystrix相关配置
参考： 
- https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.RC3/single/spring-cloud-netflix.html
- http://www.cnblogs.com/chry/p/7286601.html

访问地址： http://{host}:{port}/hystrix 

## 6、服务命名
- `eureka.instance.appname` 代表eureka管理的serviceId，用于识别注册到Eureka上的服务
- `spring.application.name` 代表微服务的服务名称，同一个服务的不同实例，可使用同一个`spring.application.name`值

