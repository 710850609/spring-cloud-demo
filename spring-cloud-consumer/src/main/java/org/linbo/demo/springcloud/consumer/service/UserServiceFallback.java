package org.linbo.demo.springcloud.consumer.service;

import com.google.common.collect.Lists;
import org.linbo.demo.springcloud.consumer.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author LinBo
 * @date 2018-12-9 16:07
 */
@Component
public class UserServiceFallback implements IUserService {

    @Override
    public User getById(Long id) {
        return new User();
    }

    @Override
    public List<User> get(User query) {
        return Lists.newArrayList();
    }

    @Override
    public User post(User user) {
        return new User();
    }

    @Override
    public List<User> map(Map<String, Object> params) {
        return Lists.newArrayList();
    }
}
