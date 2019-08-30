package org.linbo.demo.springcloud.consumer.service;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author LinBo
 */
@Component
public class UserFallbackFactory implements FallbackFactory<IUserService> {

    private static final Logger logger = LoggerFactory.getLogger(UserFallbackFactory.class);

    @Override
    public IUserService create(Throwable throwable) {
        logger.error("请求用户服务失败。", throwable);
        return new UserServiceFallback();
//        return new IUserService() {
//
//            @Override
//            public User getById(Long id) {
//                logger.error("请求用户服务失败。{}", throwable);
//                return new User();
//            }
//
//            @Override
//            public List<User> get(User query) {
//                logger.error("请求用户服务失败。{}", throwable);
//                return null;
//            }
//
//            @Override
//            public List<User> map(Map<String, Object> params) {
//                logger.error("请求用户服务失败。{}", throwable);
//                return null;
//            }
//
//            @Override
//            public User post(User user) {
//                logger.error("请求用户服务失败。{}", throwable);
//                return null;
//            }
//        };
    }
}
