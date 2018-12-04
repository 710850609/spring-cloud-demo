package org.linbo.demo.springcloud.consumer;

import org.linbo.demo.springcloud.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LinBo
 * @date 2018/12/4 11:43
 */
@FeignClient(name = "producer")
public interface IUserService {

    @GetMapping("/{id}")
    User getById(@PathVariable("id") Long id);
}
