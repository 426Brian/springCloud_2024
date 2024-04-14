package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.apis.AccountFeignApi;
import com.atguigu.cloud.apis.StorageFeignApi;
import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.mapper.OrderMapper;
import com.atguigu.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
public class OderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageFeignApi storageFeignApi;

    @Resource
    private AccountFeignApi accountFeignApi;


    @Override
    @GlobalTransactional(name = "Brian-create-order", rollbackFor = Exception.class) // AT model(模式)
    public void create(Order order) {
        // xid 全局事务检查
        String xid = RootContext.getXID();
        // 1. 新建订单
        log.info("-------------------- 开始新建订单：" + "\t" + xid);
        // 订单创建初始状态为 0
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        // 订单创建成功
        Order orderFromDB = null;
        if (result > 0) {
            // 从mysql 数据库查出刚创建的记录
            orderFromDB = orderMapper.selectOne(order);
            log.info("-------------------- 新建订单成功：orderFromDB info: " + "\t" + orderFromDB);
            System.out.println();
            // 2. 扣减库存
            int count = orderFromDB.getCount();
            log.info("-------> 订单微服务开始调用Storage库存，做扣减" + count);
            storageFeignApi.decrease(orderFromDB.getProductId(), count);
            log.info("-------> 订单微服务结束调用Storage库存，做扣减 " + count + " 完成");
            System.out.println();
            //3. 扣减账号余额
            Long money = orderFromDB.getMoney();
            log.info("-------> 订单微服务开始调用Account账号，做扣减money= " + money);
            accountFeignApi.decrease(orderFromDB.getUserId(), money);
            System.out.println();
            //4. 修改订单状态
            //订单状态status：0：创建中；1：已完结
            log.info("-------> 修改订单状态status=1");
            orderFromDB.setStatus(1);

            Example example = new Example(Order.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId", orderFromDB.getUserId());
            criteria.andEqualTo("status", 0);

            int updateResult = orderMapper.updateByExampleSelective(orderFromDB, example);

            log.info("-------> 修改订单状态完成" + "\t" + updateResult);
            log.info("-------> orderFromDB info: " + orderFromDB);
        }
        System.out.println();
        log.info("-------------------- 结束新建订单：" + "\t" + xid);
    }
}
