package org.linbo.demo.springcloud.producer.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.linbo.demo.springcloud.producer.entity.User;
import org.linbo.demo.springcloud.producer.service.IUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 林勃
 * @since 2018-12-02
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
            log.info("请求用户名: {}", username);
        }
        return userService.getById(id);
    }

    @GetMapping("")
    public List<User> get(User query, HttpServletRequest request) {
        log.debug("请求查询: {}", query);
        System.out.println(request.getQueryString());
        Wrapper<User> wrapper = new QueryWrapper<>(query);
        List<User> list = userService.list(wrapper);
        return list;
    }

    @PostMapping("")
    public User post(@RequestBody User user) {
        log.debug("post user: {}", user);
        return user;
    }

    @PutMapping("/{id}")
    public User put(@RequestBody User user) {
        log.debug("put user: {}", user);
        userService.updateById(user);
        return user;
    }

    @GetMapping("/whoami")
    public String getByUser() {
        String userName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            userName = userDetails.getUsername();
            log.debug("请求用户: {}, {}", userDetails.getUsername(), userDetails.getPassword());
        }
        return userName;
    }

}
