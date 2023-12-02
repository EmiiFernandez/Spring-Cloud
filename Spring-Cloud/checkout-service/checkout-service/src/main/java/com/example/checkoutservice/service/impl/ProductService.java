package com.example.checkoutservice.service.impl;

import com.example.checkoutservice.dto.Product;
import com.example.checkoutservice.repository.FeignProductRepository;
import com.example.checkoutservice.service.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private FeignProductRepository feignProductRepository;

    Logger log = LoggerFactory.getLogger(ProductService.class);
    public ProductService(FeignProductRepository feignProductRepository) {
        super();
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    @CircuitBreaker(name="product", fallbackMethod = "getProductFallbackMethod") //Config CB
    public Product getProduct(String id) {

        return feignProductRepository.getProductById(id);
    }

    //Método que se ejectuta si CB esta open
    //El método tiene que tener la misma firma que en el método que se este ejecutando
    //ya que lo reemplazaría
    public Product getProductFallbackMethod(String id, CallNotPermittedException exception) {
        log.error("Circuit Breaker en estado Open");

        return new Product();
    }
}
