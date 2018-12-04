package org.linbo.demo.springcloud.producer.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LinBo
 * @date 2018-12-2 13:06
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor getPaginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
