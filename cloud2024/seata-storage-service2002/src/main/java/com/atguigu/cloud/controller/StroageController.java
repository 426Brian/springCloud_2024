package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.StorageService;
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
public class StroageController {

    @Resource
    private StorageService storageService;

    /**
     * 创建订单
     */
    @PostMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count)
    {
        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功");
    }
}