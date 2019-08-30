package org.linbo.demo.springcloud.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Fegin配置
 *
 * @author LinBo
 */
@Configuration
public class UserFeignClientConfig {

    @Bean
    public Contract feignContract() {
//        return new feign.Contract.Default();
        return new SpringMvcContract();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "123456");
    }


}
