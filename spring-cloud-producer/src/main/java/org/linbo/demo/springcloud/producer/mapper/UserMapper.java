package org.linbo.demo.springcloud.producer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.linbo.demo.springcloud.producer.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 林勃
 * @since 2018-12-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
