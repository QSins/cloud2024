package com.atguigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：qinshixin
 * @Date：2024/4/9 上午10:38
 */
@RestController
@Slf4j
public class EmpowerController {

    @GetMapping(value = "/empower")
    public String empower() {
        log.info("测试Sentinel授权规则empower");
        return "测试Sentinel授权规则empower";
    }
}
