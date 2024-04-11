package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: ${NAME}
 * Pacage: com.atguigu.cloud
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/11-18:49
 * Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main83 {
    public static void main(String[] args) {
        SpringApplication.run(Main83.class,args);
    }
}