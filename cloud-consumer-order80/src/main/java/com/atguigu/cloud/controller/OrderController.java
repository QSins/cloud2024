package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author：qinshixin
 * @Date：2024/3/26 10:01
 */
@RestController
public class OrderController {
    // 先写死，硬编码
    // public static final String PAYMENT_SRV_URL = "http://localhost:8001";
    // 服务注册中心上的微服务名称
    public static final String PAYMENT_SRV_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO
     * @return
     */
    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get/" + id, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/del/{id}")
    public ResultData delOrder(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/del/" + id, ResultData.class);
    }

    @RequestMapping(value = "/consumer/pay/update")
    public ResultData updateOder(PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/update", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/getAll")
    public ResultData getAll() {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/getAll", ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private ResultData<String> getInfoByConsul() {
        String result = restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get/info", String.class);
        return ResultData.success(result);
    }

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        System.out.println("#######################################");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return instances.get(0).getServiceId() + ":" + instances.get(0).getPort();
    }

}
