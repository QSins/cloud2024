package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author：qinshixin
 * @Date：2024/4/10 上午9:20
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi
{
    // 扣减库存
    @PostMapping(value = "/storage/decrease")
    ResultData<String> decrease(@RequestParam("productId") Long productId,
                                @RequestParam("count") Integer count);

}
