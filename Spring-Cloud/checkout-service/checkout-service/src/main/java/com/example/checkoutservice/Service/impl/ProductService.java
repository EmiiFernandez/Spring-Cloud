package com.example.checkoutservice.Service.impl;

import com.example.checkoutservice.DTO.Product;
import com.example.checkoutservice.Repository.FeignProductRepository;
import com.example.checkoutservice.Service.IProductService;
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
