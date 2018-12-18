package org.linbo.demo.springcloud.consumer.service;

import org.linbo.demo.springcloud.consumer.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LinBo
 * @date 2018/12/5 15:34
 */
public interface IBasicUserserService {

    @GetMapping("/users/{id}")
    User getById(@PathVariable("id") Long id);

    @GetMapping("/users")
    List<User> get(@RequestParam User query);

    @GetMapping("/users")
    List<User> map(@RequestParam Map<String, Object> params);

    @PostMapping("/users")
    User post(@RequestBody User user);
}
