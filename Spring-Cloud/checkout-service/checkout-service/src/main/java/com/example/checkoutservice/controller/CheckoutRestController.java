package com.example.checkoutservice.controller;

import com.example.checkoutservice.model.Checkout;
import com.example.checkoutservice.service.ICheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutRestController {
    Logger log = LoggerFactory.getLogger(CheckoutRestController.class);
    private ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }

    @GetMapping()
   /* public Checkout getCheckout(@RequestParam List<String> productIds,@RequestHeader("X-Request-from") String requestFrom,@RequestHeader() Map<String,String> headers) {
       System.out.println("Enviado desde: " + requestFrom);
       if(!requestFrom.equals("gateway")) {
           log.info("Enviado desde gateway");
           return null;
       }
       log.info("Enviado desde checkout service");
        return checkoutService.buildCheckout(productIds);

    }*/
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader() Map<String,String> headers) {

        log.info("Enviado desde checkout service");
        return checkoutService.buildCheckout(productIds);

    }
}
