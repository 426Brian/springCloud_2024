package com.atguigu.cloud.mygateway;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

/**
 * ClassName: MyGatewayFilterFactory
 * Pacage: com.atguigu.cloud.mygateway
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/11-12:40
 * Version: V1.0
 */
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    public MyGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(MyGatewayFilterFactory.Config config) {

        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                System.out.println("进入了自定义网关过滤器 MyGatewayFilterFactory，status: " + config.getStatus());
                if (request.getQueryParams().containsKey("atguigu")) {
                    return chain.filter(exchange); // 放行
                } else {
                    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                    return exchange.getResponse().setComplete();
                }
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("status");
    }

    public static class Config {
        @Getter
        @Setter
        private String status; // 允许访问的标志
    }
}

