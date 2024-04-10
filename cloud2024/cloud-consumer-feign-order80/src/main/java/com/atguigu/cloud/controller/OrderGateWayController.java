package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import feign.Headers;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderGateWayController
 * Pacage: com.atguigu.cloud.controller
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/9-18:13
 * Version: V1.0
 */
@RestController
public class OrderGateWayController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id) {
        return payFeignApi.getById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return payFeignApi.getGatewayInfo();
    }

    @GetMapping(value = "/feign/pay/gateway/predicate")
    public ResultData<String> getGatewayPredicate(@RequestHeader("Cookie") String cookie) {
        System.out.println("getGatewayPredicate() -----------------------");
        return payFeignApi.getGatewayPredicate(cookie);
    }

}