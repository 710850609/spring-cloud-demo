package org.linbo.demo.springcloud.biz.intf;

import org.linbo.demo.springcloud.biz.domain.User;

/**
 * @author LinBo
 * @date 2019/8/30 9:52
 */
public interface UserService {

    /**
     * 根据id查询用户信息
     * @Author LinBo
     * @Date 2019/8/30 10:02
     * @param id
     * @return {@link User}
     **/
    User getById(String id);



}
