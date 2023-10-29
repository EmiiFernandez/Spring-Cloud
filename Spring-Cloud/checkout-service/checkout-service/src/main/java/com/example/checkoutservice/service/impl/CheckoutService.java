package com.example.checkoutservice.service.impl;

import com.example.checkoutservice.dto.Product;
import com.example.checkoutservice.model.Checkout;
import com.example.checkoutservice.service.ICheckoutService;
import com.example.checkoutservice.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheckoutService implements ICheckoutService {

    private IProductService productService;

    public CheckoutService(IProductService productService) {
        this.productService = productService;
    }

//Recorre el listado de ID. Por cada ID envia el get a product Ser
    @Override
    public Checkout buildCheckout(List<String> productIds) {
        Double total = 0.0;
        for(String id : productIds) {
            Product product = productService.getProduct(id);
            System.out.println("Respuesta desde " + product.getInstance());
            total += product.getPrice();
        }
        Checkout checkout = new Checkout("234", "www.digitalhouse/checkout?code=234", total.toString(), List.of("credit_card"));

        return checkout;
    }
}
