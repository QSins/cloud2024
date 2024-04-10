package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author：qinshixin
 * @Date：2024/4/9 下午2:34
 */
@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi
{

    @GetMapping(value = "/pay/nacos/get/{orderNo}")
    ResultData<String> getPayByOrderNo(@PathVariable("orderNo") String orderNo);

}
