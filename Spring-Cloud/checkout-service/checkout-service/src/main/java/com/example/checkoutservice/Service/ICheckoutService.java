package com.example.checkoutservice.Service;

import com.example.checkoutservice.Model.Checkout;

import java.util.List;

public interface ICheckoutService {
    public Checkout buildCheckout(List<String> productIds);
}
