package org.linbo.demo.springcloud.consumer.service;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LinBo
 * @date 2018/12/4 11:43
 */
@FeignClient(name = "producer", configuration = IUserService.UserFeignClientConfig.class, fallback = UserServiceFallback.class)
public interface IUserService extends IBasicUserserService {

    @Configuration
    class UserFeignClientConfig {

        @Bean
        public BasicAuthRequestInterceptor userAuthRequestInterceptor() {
            return new BasicAuthRequestInterceptor("user", "123456");
        }
    }
}
