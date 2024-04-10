package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author：qinshixin
 * @Date：2024/3/30 16:42
 */
@FeignClient(value = "cloud-gateway")
public interface PayFeignApi
{

    /**
     * 新增一条支付流水相关记录
     *
     * @param payDTO
     * @return
     */
    @PostMapping(value = "/pay/add")
    ResultData addPay(@RequestBody PayDTO payDTO);

    /**
     * 按照主键记录查询支付流水信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/get/{id}")
    ResultData getPayInfo(@PathVariable("id") Integer id);

    /**
     * 查询所有支付流水信息
     *
     * @return
     */
    @GetMapping(value = "/pay/getAll")
    ResultData getAll();

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping(value = "/pay/get/info")
    String myLb();

    /**
     * Resilience4j CircuitBreaker 的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

    /**
     * Resilience4j Bulkhead 的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id") Integer id);

    /**
     * Resilience4j 限流的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/rateLimit/{id}")
    String myRateLimit(@PathVariable("id") Integer id);

    /**
     * Micrometer(Sleuth)进行链路监控的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例01
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     *
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    ResultData<String> getGatewayInfo();
}
