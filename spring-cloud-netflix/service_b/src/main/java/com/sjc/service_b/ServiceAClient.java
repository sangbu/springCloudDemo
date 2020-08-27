package com.sjc.service_b;

import com.sjc.api.ServiceAInterface;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author by SangJiacun
 * @Date 2020/8/25 17:32
 */
@FeignClient("ServiceA")
public interface ServiceAClient extends ServiceAInterface {
}
