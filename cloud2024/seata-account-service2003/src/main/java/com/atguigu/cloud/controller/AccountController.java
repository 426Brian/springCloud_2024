package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: A
 * Pacage: com.atguigu.cloud.controller
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/13-15:18
 * Version: V1.0
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 创建订单
     */
    @PostMapping("/account/decrease")
    public ResultData decrease(Long userId, Long money)
    {
        accountService.decrease(userId, money);
        return ResultData.success("扣减库存成功");
    }
}