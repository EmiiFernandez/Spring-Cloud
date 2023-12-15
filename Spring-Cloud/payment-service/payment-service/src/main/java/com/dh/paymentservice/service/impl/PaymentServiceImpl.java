package com.dh.paymentservice.service.impl;

import com.dh.paymentservice.client.PaymentClient;
import com.dh.paymentservice.model.Payment;
import com.dh.paymentservice.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PublishNotificationServiceImpl publishNotificationService;

    private PaymentClient paymentClient;

    public PaymentServiceImpl(PublishNotificationServiceImpl publishNotificationService, PaymentClient paymentClient) {
        this.publishNotificationService = publishNotificationService;
        this.paymentClient = paymentClient;
    }

    public void CreatePayment(Payment payment) {
        //crear un payment
        paymentClient.createPayment(payment);
        //utilizamos el servicio publish para enviar el mensaje a RabbitMQ
        publishNotificationService.sendMessageToTopic(payment.getClientId());
    }
}
