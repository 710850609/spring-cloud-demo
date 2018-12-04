package org.linbo.demo.springcloud.consumer.util;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LinBo
 * @date 2018/12/3 19:53
 */
@Component
public class DiscoveryUtil {

    @Resource
    private DiscoveryClient discoveryClient;

    public String getServiceUrl(String key) {
        List<ServiceInstance> instances = discoveryClient.getInstances(key);
        if (!CollectionUtils.isEmpty(instances)) {
            return instances.get(0).getUri().toString();
        }
        return null;
    }
}
