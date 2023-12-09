package com.example.checkoutservice.repository;

import com.example.checkoutservice.configuration.LoadBalancerConfiguration;
import com.example.checkoutservice.dto.Product;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
@FeignClient(name = "products-service") //nombre del serv al que queremos comunicarnos
//@FeignClient(name = "products", url = "http://localhost:8084") //nombre del serv al que queremos comunicarnos
//Configuración para LoadBalancer Random
//@LoadBalancerClient(value = "products-service", configuration = LoadBalancerConfiguration.class)
public interface FeignProductRepository {
    @RequestMapping(method = RequestMethod.GET, value="/products")
    Product getProductById(@RequestParam String id, @RequestParam Boolean throwError);
}
