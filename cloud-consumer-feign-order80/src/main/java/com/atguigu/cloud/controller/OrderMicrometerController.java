package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：qinshixin
 * @Date：2024/4/4 8:36
 */
@RestController
@Slf4j
public class OrderMicrometerController {
    @Resource
    private PayFeignApi payFeignApi;

    /**
     * Micrometer(Sleuth)进行链路监控的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id) {
        return payFeignApi.myMicrometer(id);
    }
}
