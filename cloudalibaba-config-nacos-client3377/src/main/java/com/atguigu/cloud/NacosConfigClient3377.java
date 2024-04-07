package com.atguigu.cloud;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author：qinshixin
 * @Date：2024/4/7 11:21
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient3377 {
   public static void main(String[] args) {
       SpringApplication.run(Main.class, args);
   }
}