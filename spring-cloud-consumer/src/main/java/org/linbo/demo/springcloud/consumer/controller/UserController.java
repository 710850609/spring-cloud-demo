package org.linbo.demo.springcloud.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.linbo.demo.springcloud.consumer.entity.User;
import org.linbo.demo.springcloud.consumer.util.DiscoveryUtil;
import org.linbo.demo.springcloud.consumer.util.EurekaUtil;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 使用服务发现进行调用
 *
 * @author LinBo
 */
@RestController
@Slf4j
public class UserController {

    // 这里使用了 ribbo做负载均衡后，如果还用注入的restTemplate实例，请求真实的地址，会被ribbon误识别为服务id
    // 直接使用new处理的实例进行请求
    private RestTemplate restTemplate = new RestTemplate();

    @Resource
    private EurekaUtil eurekaUtil;

    @Resource
    private DiscoveryUtil discoveryUtil;

    private static final String SERVICE_ID = "PRODUCER";

    @GetMapping("/eureka/{id}")
    public User getByEureka(@PathVariable("id") Long id) {
        String url = eurekaUtil.getServiceUrl(SERVICE_ID) + "users/" + id;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        User user = response.getBody();
        log.debug("请求用户信息: {}", user);
        return user;
    }

    @GetMapping("/discovery/{id}")
    public User getByDiscovery(@PathVariable("id") Long id) {
        String url = discoveryUtil.getServiceUrl(SERVICE_ID) + "users/" + id;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        User user = response.getBody();
        log.debug("请求用户信息: {}", user);
        return user;
    }

}
