package com.todolist.todolist.infrastructure.exception;

public class ChangeStatusException extends RuntimeException {

    public ChangeStatusException() {

    }

    public ChangeStatusException(String message) {
        super(message);
    }
}
