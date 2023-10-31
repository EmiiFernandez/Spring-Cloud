package com.example.product.service.controller;

import com.example.product.service.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")
public class ProductRestController {

    @GetMapping Product getProduct(@RequestParam String id) {
        return new Product(id, "Notebook", 2000.0, "Instance 1");
    }
}