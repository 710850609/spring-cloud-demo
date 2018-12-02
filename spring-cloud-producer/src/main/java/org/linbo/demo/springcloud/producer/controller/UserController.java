package org.linbo.demo.springcloud.producer.controller;


import org.linbo.demo.springcloud.producer.entity.User;
import org.linbo.demo.springcloud.producer.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 林勃
 * @since 2018-12-02
 */
@RestController
@RequestMapping("//users")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

}
