package com.todolist.todolist.core.usecase;

import com.todolist.todolist.core.entity.Todo;

import java.util.List;

public interface GetAllTodosUseCase {
    List<Todo> execute();
}
