package org.linbo.demo.springcloud.consumer.util;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author LinBo
 * @date 2018/12/3 19:45
 */
@Component
public class EurekaUtil {

    @Resource
    private EurekaClient client;

    public String getServiceUrl(String key) {
        InstanceInfo instanceInfo = client.getNextServerFromEureka(key, false);
        return instanceInfo.getHomePageUrl();
    }
}
