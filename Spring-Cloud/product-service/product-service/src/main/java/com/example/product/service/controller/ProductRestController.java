package com.example.product.service.controller;

import com.example.product.service.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")
public class ProductRestController {

    @GetMapping()
    public Product getProduct(@RequestParam String id, @RequestParam(defaultValue = "false") Boolean throwError) {
        if(throwError) {
            throw new RuntimeException(); //Esto es si throwError entra a true
        }
        return new Product(id, "Notebook", 2000.0, "Instance 1");
    }
}

/*
@RequestParam(defaultValue = "false") Boolean throwError
Lo utilizamos para probar el Circuit Breaker de checkout-service
En false no bloquearia el flujo de datos
En true el circuit breaker estará configurado para que de un mensaje generico
 */