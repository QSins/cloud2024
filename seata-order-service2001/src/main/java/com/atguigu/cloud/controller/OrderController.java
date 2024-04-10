package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：qinshixin
 * @Date：2024/4/10 上午11:36
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @GetMapping(value = "/order/create")
    public ResultData<Order> create(Order order) {
        orderService.createOrder(order);
        return ResultData.success(order);
    }
}
