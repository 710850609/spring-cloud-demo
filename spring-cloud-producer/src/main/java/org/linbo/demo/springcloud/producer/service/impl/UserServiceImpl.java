package org.linbo.demo.springcloud.producer.service.impl;

import org.linbo.demo.springcloud.producer.entity.User;
import org.linbo.demo.springcloud.producer.mapper.UserMapper;
import org.linbo.demo.springcloud.producer.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 林勃
 * @since 2018-12-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
