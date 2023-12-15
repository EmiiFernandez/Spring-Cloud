package com.dh.paymentservice.service.impl;

import com.dh.paymentservice.service.PublishNotificationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishNotificationServiceImpl implements PublishNotificationService {


    //Utilizamos el cliente de RabbitMQ para enviar el mensaje a Rabbit
    private RabbitTemplate rabbitTemplate;

    public PublishNotificationServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //Publicar mensaje en un tópico
    public void sendMessageToTopic(String message) {
                                              //nombre del tópico
            rabbitTemplate.convertAndSend("send-notification", message);
        }

}
