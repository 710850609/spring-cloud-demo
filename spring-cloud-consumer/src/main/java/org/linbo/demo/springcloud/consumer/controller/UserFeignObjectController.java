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
import java.util.Map;

/**
 * 使用带有安全认证的feign作为服务调用客户端
 *
 * @author LinBo
 */
@RestController
@RequestMapping("/feign-object")
@Slf4j
public class UserFeignObjectController {

    @Resource
    private IUserService userService;

    @GetMapping("/users")
    public List<User> list() {
        List<User> user = userService.get(new User());
        log.debug("请求用户信息: {}", user);
        return user;
    }

    @GetMapping("/users/{id}")
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

    @GetMapping("/map")
    public List<User> map(@RequestParam Map<String, Object> params) {
        log.debug("get: {}", params);
        List<User> users = userService.map(params);
        return users;
    }

    @GetMapping("/post")
    public User post(User user) {
        log.debug("post: {}", user);
        User post = userService.post(user);
        return post;
    }

}
