package org.linbo.demo.springcloud.consumer.controller;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.linbo.demo.springcloud.consumer.entity.User;
import org.linbo.demo.springcloud.consumer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 使用带有安全认证的feign作为服务调用客户端
 * @author LinBo
 * @date 2018/12/3 19:41
 */
@RestController
@RequestMapping("/feign-object")
@Slf4j
public class UserFeignObjectController {

    @Resource
    private IUserService userService;

    @GetMapping("/user/{id}")
    public User getByUserId(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        log.debug("请求用户信息: {}", user);
        return user;
    }

    @GetMapping("/get")
    public List<User> get(User params) {
        log.debug("get: {}", params);
        List<User> users = userService.get(params);
        return users;
    }

    @GetMapping("/post")
    public User post(User user) {
        log.debug("post: {}", user);
        User post = userService.post(user);
        return post;
    }

}