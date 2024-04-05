package com.atguigu.cloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author：qinshixin
 * @Date：2024/4/5 19:14
 */
public class FeignCookieInterceptor implements RequestInterceptor {

    public FeignCookieInterceptor(HttpServletRequest request) {
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Cookie",  "username=qsx");
    }
}
