package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: OrderController
 * Pacage: com.atguigu.cloud.controller
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/5-18:43
 * Version: V1.0
 */

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;
    @Value("${server.port}")
    private String ServerPort;

    @PostMapping(value = "/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping(value = "/feign/pay/get/{id}")
    public ResultData getPayId(@PathVariable("id") Integer id) {
        ResultData payInfo = payFeignApi.getPayInfo(id);
        return payInfo;
    }

    @GetMapping(value = "/feign/pay/mylb")
    public String mylb() {
        return payFeignApi.mylb();
    }

    @GetMapping(value = "/feign/pay/get/info")
    public String getAtguiguInfo() {
        String configInfo = payFeignApi.getConfigProperties();
        return configInfo;
    }
}
