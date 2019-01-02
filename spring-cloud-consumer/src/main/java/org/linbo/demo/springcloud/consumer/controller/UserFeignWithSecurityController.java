package org.linbo.demo.springcloud.consumer.controller;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.linbo.demo.springcloud.consumer.entity.User;
import org.linbo.demo.springcloud.consumer.service.IBasicUserserService;
import org.linbo.demo.springcloud.consumer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用带有安全认证的feign作为服务调用客户端
 *
 * @author LinBo
 * @date 2018/12/3 19:41
 */
@Import(FeignClientsConfiguration.class)
@RestController
@RequestMapping("/feign-security")
@Slf4j
public class UserFeignWithSecurityController {

    private IBasicUserserService userService;

    private IBasicUserserService adminService;

    @Autowired
    public UserFeignWithSecurityController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        log.info("初始化Feign, decoder:{}, encoder: {}, client: {}, contract: {}", decoder, encoder, client, contract);
        this.userService = Feign.builder().client(client).decoder(decoder).encoder(encoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "123456"))
                .target(IUserService.class, "http://producer/");
        this.adminService = Feign.builder().client(client).decoder(decoder).encoder(encoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "123456"))
                .target(IUserService.class, "http://producer/");
    }

    @GetMapping("/user/{id}")
    public User getByUserId(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        log.debug("请求用户信息: {}", user);
        return user;
    }

    @GetMapping("/admin/{id}")
    public User getByAdminId(@PathVariable("id") Long id) {
        User user = adminService.getById(id);
        log.debug("请求用户信息: {}", user);
        return user;
    }

}
