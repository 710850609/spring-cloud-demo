package org.linbo.demo.springcloud.consumer.service;

import org.linbo.demo.springcloud.consumer.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LinBo
 * @date 2018/12/5 15:34
 */
public interface IBasicUserserService {

    @GetMapping("/users/{id}")
    User getById(@PathVariable("id") Long id);

    @GetMapping("/users")
    List<User> get(User query);

    @PostMapping("/users")
    User post(@RequestBody User user);
}
