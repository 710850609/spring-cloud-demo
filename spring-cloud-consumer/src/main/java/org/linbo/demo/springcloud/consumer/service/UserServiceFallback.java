package org.linbo.demo.springcloud.consumer.service;

import org.linbo.demo.springcloud.consumer.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author LinBo
 */
@Component
public class UserServiceFallback implements IUserService {

    @Override
    public User getById(Long id) {
        return new User();
    }

    @Override
    public List<User> get(User query) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public User post(User user) {
        return new User();
    }

    @Override
    public List<User> map(Map<String, Object> params) {
        return Collections.EMPTY_LIST;
    }
}
