package com.example.checkoutservice.Repository;

import com.example.checkoutservice.DTO.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
@FeignClient(name = "products-service") //nombre del serv al que queremos comunicarnos
public interface FeignProductRepository {
    @RequestMapping(method = RequestMethod.GET, value="/products")
    Product getProductById(@RequestParam String id);
}
