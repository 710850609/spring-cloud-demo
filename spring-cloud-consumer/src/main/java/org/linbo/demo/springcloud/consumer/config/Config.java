package org.linbo.demo.springcloud.consumer.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author LinBo
 * @date 2018/12/3 20:01
 */
@Configuration
public class Config {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 设置Feign的日志记录
     * NONE: 不记录（默认）
     * BAISC: 仅记录请求方法、URL、响应状态码以及执行时间
     * HEADERS: 记录BAISC级别的基础上，记录请求和响应header
     * FULL: 记录请求和响应的header、body和元数据
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


}
