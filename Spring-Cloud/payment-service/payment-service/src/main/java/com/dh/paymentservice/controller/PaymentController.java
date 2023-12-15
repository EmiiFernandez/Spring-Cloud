package com.dh.paymentservice.controller;

import com.dh.paymentservice.model.Payment;
import com.dh.paymentservice.service.impl.PaymentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    //Creamos el pago y enviamos al tópico un mensaje
    @PostMapping()
    public void createPayment(@RequestBody Payment payment) {
        paymentService.CreatePayment(payment);
    }
}
