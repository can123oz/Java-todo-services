package com.todolist.todolist.infrastructure.gateway;

public interface MessageProducerService {
    void send(String message);
}
