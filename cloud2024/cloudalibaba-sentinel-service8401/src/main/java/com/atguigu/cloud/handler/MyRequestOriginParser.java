package com.atguigu.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyRequestOriginParser
 * Pacage: com.atguigu.cloud.handler
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/12-19:20
 * Version: V1.0
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser
{
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameter("serverName");
    }
}
