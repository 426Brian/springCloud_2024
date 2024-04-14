package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.mapper.StorageMapper;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("-------> 订单微服务开始调用Storage库存，做扣减count= "+count);
        storageMapper.decrease(productId, count);
        log.info("-------> 订单微服务结束调用Storage库存，做扣减 "+count+" 完成");
    }
}
