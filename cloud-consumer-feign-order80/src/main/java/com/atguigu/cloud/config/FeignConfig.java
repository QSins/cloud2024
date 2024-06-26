package com.atguigu.cloud.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.Retryer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：qinshixin
 * @Date：2024/3/30 20:24
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer() {
        // Feign默认配置是不走重试策略的
        return Retryer.NEVER_RETRY;

        // 最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
//        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor(HttpServletRequest request) {
        return new FeignCookieInterceptor(request);
    }
}
