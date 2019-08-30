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
 * 使用ribbo做负载均衡的ResTemplate客户端
 *
 * @author LinBo
 */
@RestController
@RequestMapping("/ribbon")
@Slf4j
public class UserRibbonController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    private static final String SERVICE_ID = "PRODUCER";

    @GetMapping("/{id}")
    public User getByRibbo(@PathVariable("id") Long id) {
        String url = "http://" + SERVICE_ID + "/users/" + id;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        User user = response.getBody();
        log.debug("请求用户信息: {}", user);
        return user;
    }

    @GetMapping("/instance")
    public String logInstance() {
        ServiceInstance producer = loadBalancerClient.choose(SERVICE_ID);
        String instance = producer.getScheme() + "://" + producer.getHost() + ":" + producer.getPort() + "/" + producer.getServiceId();
        log.debug("当前负载实例: {}", instance);
        return instance;
    }

}
