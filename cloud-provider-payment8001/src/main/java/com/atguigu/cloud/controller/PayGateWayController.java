package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

/**
 * @Author：qinshixin
 * @Date：2024/4/4 20:47
 */
@RestController
@Slf4j
public class PayGateWayController {
    @Resource
    private PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway into test: " + IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request) {
        StringBuilder result = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headName = headerNames.nextElement();
            String headValue = request.getHeader(headName);
            log.info("请求头名：" + headName + "\t\t\t" + "请求头值：" + headValue);
            if ("X-Request-atguigu1".equalsIgnoreCase(headName)
                    || "X-Request-atguigu2".equalsIgnoreCase(headName)) {
                result.append(headName).append("\t").append(headValue).append(" ");
            }
        }

        System.out.println("=============================================");
        String customerId = request.getParameter("customerId");
        System.out.println("request Parameter customerId: " + customerId);

        String customerName = request.getParameter("customerName");
        System.out.println("request Parameter customerName: " + customerName);
        System.out.println("=============================================");

        return ResultData.success("getGatewayFilter 过滤器 test：" + result + "\t" + DateUtil.now());
    }
}
