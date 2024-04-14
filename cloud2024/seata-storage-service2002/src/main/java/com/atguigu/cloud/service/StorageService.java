package com.atguigu.cloud.service;

/**
 * ClassName: OrderService
 * Pacage: com.atguigu.cloud.service
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/13-14:54
 * Version: V1.0
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
