package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @Author：qinshixin
 * @Date：2024/4/10 上午11:17
 */
public interface OrderService
{
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}
