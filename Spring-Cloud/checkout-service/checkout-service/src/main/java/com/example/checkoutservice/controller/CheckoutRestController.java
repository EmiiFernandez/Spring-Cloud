package com.example.checkoutservice.controller;

import com.example.checkoutservice.model.Checkout;
import com.example.checkoutservice.service.ICheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/checkout")
public class CheckoutRestController {
    private ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }

    @GetMapping()
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader("X-Request-from") String requestfrom) {
       System.out.println("Enviado desde: " + requestfrom);
       if(!requestfrom.equals("gateway")) {
           return null;
       }
        return checkoutService.buildCheckout(productIds);
    }
}
