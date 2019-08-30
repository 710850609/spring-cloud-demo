package org.linbo.demo.springcloud.biz.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LinBo
 * @date 2019-08-30 9:54
 */
@Data
public class User implements Serializable {

    private String id;

    private String name;

    private String nickeName;

    private Date birthDay;

}
