package com.dh.notificationservice.service.impl;

import com.dh.notificationservice.service.NotificationConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumerImpl implements NotificationConsumer {
    Logger log = LoggerFactory.getLogger(NotificationConsumerImpl.class);

                     //nombre del tópico que estamos escuchando
    @RabbitListener(queues = "send-notification")
    public void consumer(String message) {
        log.info("Recibiendo mensaje del tópico send-notification " + message);
    }

}
