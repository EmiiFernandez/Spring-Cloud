package com.example.checkoutservice.Service.impl;

import com.example.checkoutservice.Model.Checkout;
import com.example.checkoutservice.Service.ICheckoutService;

import java.util.List;

public class CheckoutServiceImpl implements ICheckoutService {

    private IProductService productService;

    public CheckoutServiceImpl(IProductService productService) {
        this.productService = productService;
    }

//Recorre el listado de ID. Por cada ID envia el get a product Ser
    @Override
    public Checkout buildCheckout(List<String> productIds) {
        Double total = 0.0;
        for(String id = productIds) {
            Product product = productService.getProduct(id);
            total += product.getPrice();
        }
        Checkout checkout = new Checkout("234", "www.digitalhouse/checkout?code=234", total.toString(), List.of("credit_card"));

        return checkout;
    }
}
