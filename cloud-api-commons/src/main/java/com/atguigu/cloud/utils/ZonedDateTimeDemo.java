package com.atguigu.cloud.utils;

import java.time.ZonedDateTime;

/**
 * @Author：qinshixin
 * @Date：2024/4/5 12:14
 */
public class ZonedDateTimeDemo {
    public static void main(String[] args) {
        // 默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
