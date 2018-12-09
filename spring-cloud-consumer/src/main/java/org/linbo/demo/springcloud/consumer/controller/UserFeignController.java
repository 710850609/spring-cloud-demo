package org.linbo.demo.springcloud.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.linbo.demo.springcloud.consumer.entity.User;
import org.linbo.demo.springcloud.consumer.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 使用feign作为服务调用客户端
 * @author LinBo
 * @date 2018/12/3 19:41
 */
@RestController
@RequestMapping("/feign")
@Slf4j
public class UserFeignController {

    @Resource
    private IUserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        log.debug("请求用户信息: {}", user);
        return user;
    }

}
