package com.todolist.todolist.infrastructure.delivery;

import com.todolist.todolist.infrastructure.delivery.dto.CreateTodoRequest;
import com.todolist.todolist.infrastructure.delivery.dto.GetTodoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TodoController {
    ResponseEntity<List<GetTodoResponse>> getAll();
    ResponseEntity<Void> create(CreateTodoRequest createTodoRequest);

    ResponseEntity<GetTodoResponse> getById(String id);
    ResponseEntity<Void> delete(String id);
    ResponseEntity<String> changeStatus(String id);
}
