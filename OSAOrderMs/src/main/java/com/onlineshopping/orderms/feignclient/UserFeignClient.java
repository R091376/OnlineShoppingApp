package com.onlineshopping.orderms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineshopping.orderms.model.User;

@FeignClient(name = "user-ms")
public interface UserFeignClient {
    @GetMapping("/api/users/{userId}")
    User getUserById(@PathVariable("userId") Long userId);
}
