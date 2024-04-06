package com.atguigu.cloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: FeignConfig
 * Pacage: com.atguigu.cloud.config
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/6-9:34
 * Version: V1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    Retryer retryer(){
//        return Retryer.NEVER_RETRY; // Feign 默认不走重试策略

        // 最大请求次数为3，出事间隔时间为100ms, 重试最大间隔时间为1s.
        return new Retryer.Default(100, 1, 3);

    }

}
