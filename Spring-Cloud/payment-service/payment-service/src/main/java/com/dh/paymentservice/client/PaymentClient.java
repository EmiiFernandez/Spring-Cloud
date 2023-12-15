package com.dh.paymentservice.client;

import com.dh.paymentservice.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentClient {

    public Boolean createPayment (Payment payment) {
        //ejecuta una llamada a un servicio externo para crear el pago

        return true;
    }
}
