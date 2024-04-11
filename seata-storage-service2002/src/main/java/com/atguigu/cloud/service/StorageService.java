package com.atguigu.cloud.service;

/**
 * @Author：qinshixin
 * @Date：2024/4/11 上午11:43
 */
public interface StorageService
{
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
