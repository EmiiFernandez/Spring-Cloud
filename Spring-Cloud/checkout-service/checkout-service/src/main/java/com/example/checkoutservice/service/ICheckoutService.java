package com.example.checkoutservice.service;

import com.example.checkoutservice.model.Checkout;

import java.util.List;

public interface ICheckoutService {
    public Checkout buildCheckout(List<String> productIds);
}
