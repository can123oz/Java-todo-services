package com.todolist.todolist.infrastructure.gateway.broker;

import com.todolist.todolist.infrastructure.gateway.MessageProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerServiceImpl implements MessageProducerService {
    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing-key.name}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MessageProducerServiceImpl.class);

    public MessageProducerServiceImpl( RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void send(String message) {
        logger.info("Message Send : "+ message);
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
