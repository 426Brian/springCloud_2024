package com.atguigu.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: FlowLimitController
 * Pacage: com.atguigu.cloud.controller
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/11-23:55
 * Version: V1.0
 */
@RestController
public class FlowLimitController
{

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }
}
