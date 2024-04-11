package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：qinshixin
 * @Date：2024/4/11 下午2:57
 */
@RestController
public class AccountController
{
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping(value = "/account/decrease", method = RequestMethod.POST)
    public ResultData<String> decrease(@RequestParam("userId") Long userId,
    @RequestParam("money") Long money){
        accountService.decrease(userId,money);
        return ResultData.success("扣减账户余额成功！");
    }
}
