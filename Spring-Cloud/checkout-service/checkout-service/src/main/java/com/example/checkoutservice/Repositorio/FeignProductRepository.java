package com.example.checkoutservice.Repositorio;

import org.springframework.cloud.openfeign.FeignClient;
@FeignClient(name = "products-service")
public interface FeignProductRepository {
    Product
}
