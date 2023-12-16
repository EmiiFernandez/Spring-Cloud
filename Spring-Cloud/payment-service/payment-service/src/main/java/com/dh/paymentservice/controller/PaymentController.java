package com.dh.paymentservice.controller;

import com.dh.paymentservice.model.Payment;
import com.dh.paymentservice.service.impl.PaymentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    Logger log = LoggerFactory.getLogger(PaymentController.class);

    private PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public Payment getPayment(String id) {
        log.info("Intentando obtener payment con id: " + id);
        return new Payment(id,300.0f,"cli-236-6580","own-569-4878");
    }

    //Creamos el pago y enviamos al tópico un mensaje
    @PostMapping()
    public void createPayment(@RequestBody Payment payment) {
        paymentService.CreatePayment(payment);
    }
}
