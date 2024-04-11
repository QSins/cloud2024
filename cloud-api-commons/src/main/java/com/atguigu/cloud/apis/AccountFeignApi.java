package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author：qinshixin
 * @Date：2024/4/10 上午9:25
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi
{
    // 扣减账户余额
    @PostMapping(value = "/account/decrease")
    ResultData<String> decrease(@RequestParam("userId") Long userId,
                                @RequestParam("money") Long money);
}
