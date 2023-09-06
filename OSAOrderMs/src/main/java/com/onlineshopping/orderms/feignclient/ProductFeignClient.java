package com.onlineshopping.orderms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineshopping.orderms.model.Product;

@FeignClient(name = "product-ms")
public interface ProductFeignClient {
    @GetMapping("/api/products/{productId}")
    Product getProductById(@PathVariable("productId") Long productId);
}
