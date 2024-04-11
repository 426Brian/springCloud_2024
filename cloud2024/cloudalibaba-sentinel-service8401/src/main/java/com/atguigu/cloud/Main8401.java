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
 * @Create: 2024/4/11-23:53
 * Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main8401 {
    public static void main(String[] args) {

        SpringApplication.run(Main8401.class, args);
    }
}