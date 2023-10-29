package com.example.checkoutservice.service.impl;

import com.example.checkoutservice.dto.Product;
import com.example.checkoutservice.repository.FeignProductRepository;
import com.example.checkoutservice.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private FeignProductRepository feignProductRepository;

    public ProductService(FeignProductRepository feignProductRepository) {
        super();
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    public Product getProduct(String id) {
        return feignProductRepository.getProductById(id);
    }
}
