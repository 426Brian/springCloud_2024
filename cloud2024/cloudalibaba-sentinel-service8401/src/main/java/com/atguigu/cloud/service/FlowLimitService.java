package com.atguigu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * ClassName: FlowLimitService
 * Pacage: com.atguigu.cloud.service
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/12-12:16
 * Version: V1.0
 */
@Service
public class FlowLimitService
{
    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}
