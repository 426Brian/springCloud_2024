package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.mapper.AccountMapper;
import com.atguigu.cloud.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: OderServiceImpl
 * Pacage: com.atguigu.cloud.service.impl
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/13-14:56
 * Version: V1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 模拟超时异常，全局事务回滚
     */
    public static void myTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void decrease(Long userId, Long money) {
        log.info("-------> 订单微服务开始调用Account，做扣减money= " + money);
        accountMapper.decrease(userId, money);
        myTimeOut();
//        int i = 10 / 0;
        log.info("-------> 订单微服务开始调用Account，做扣减 " + money + "完成");
    }
}
