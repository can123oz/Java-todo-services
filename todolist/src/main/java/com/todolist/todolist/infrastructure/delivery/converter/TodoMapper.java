package com.todolist.todolist.infrastructure.delivery.converter;

import com.todolist.todolist.core.entity.Todo;
import com.todolist.todolist.infrastructure.delivery.dto.CreateTodoRequest;
import com.todolist.todolist.infrastructure.delivery.dto.GetTodoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);
    @Mapping(source = "description",target = "description")
    Todo createcrCreateToTodoRequest(CreateTodoRequest createTodoRequest);

    @Mapping(source = "description",target = "description")
    GetTodoResponse todoToGetTodoResponse(Todo todo);


}