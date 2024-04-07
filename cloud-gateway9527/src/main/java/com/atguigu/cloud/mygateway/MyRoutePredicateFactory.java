package com.atguigu.cloud.mygateway;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author：qinshixin
 * @Date：2024/4/6 14:55
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    @Validated
    public static class Config {
        // 钻、金、银等用户信息
        @Setter
        @Getter
        @NotEmpty
        private String userType;
    }

    public MyRoutePredicateFactory() {
        super(MyRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return serverWebExchange -> {
            // 检查request的参数里面，userType是否为指定的值，符合配置就通过
            String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
            if (userType == null) {
                return false;
            }

            //如果说参数存在，就和config的数据进行比较
            return userType.equals(config.getUserType());
        };
    }
}
