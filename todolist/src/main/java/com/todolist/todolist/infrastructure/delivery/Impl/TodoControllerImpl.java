package com.todolist.todolist.infrastructure.delivery.Impl;

import com.todolist.todolist.core.entity.Todo;
import com.todolist.todolist.core.usecase.*;
import com.todolist.todolist.infrastructure.delivery.TodoController;
import com.todolist.todolist.infrastructure.delivery.converter.TodoMapper;
import com.todolist.todolist.infrastructure.delivery.dto.CreateTodoRequest;
import com.todolist.todolist.infrastructure.delivery.dto.GetTodoResponse;
import com.todolist.todolist.infrastructure.exception.TodoNotFoundException;
import com.todolist.todolist.infrastructure.gateway.MessageProducerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/todo")
public class TodoControllerImpl implements TodoController {

    private final CreateTodoUseCase createTodoUseCase;
    public final GetByIdTodoUseCase getByIdTodoUseCase;
    private final GetAllTodosUseCase getAllTodosUseCase;
    private final Environment environment;
    private final MessageProducerService messageProducerService;
    private final DeleteTodoUseCase deleteTodoUseCase;
    private final CompleteTodoUseCase completeTodoUseCase;
    Logger logger = LoggerFactory.getLogger(TodoControllerImpl.class);

    public TodoControllerImpl(CreateTodoUseCase createTodoUseCase,
                              GetByIdTodoUseCase getByIdTodoUseCase,
                              GetAllTodosUseCase getAllTodosUseCase,
                              Environment environment,
                              MessageProducerService messageProducerService,
                              DeleteTodoUseCase deleteTodoUseCase,
                              CompleteTodoUseCase completeTodoUseCase) {
        this.createTodoUseCase = createTodoUseCase;
        this.getByIdTodoUseCase = getByIdTodoUseCase;
        this.getAllTodosUseCase = getAllTodosUseCase;
        this.environment = environment;
        this.messageProducerService = messageProducerService;
        this.deleteTodoUseCase = deleteTodoUseCase;
        this.completeTodoUseCase = completeTodoUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateTodoRequest createTodoRequest) {

        Todo todo = TodoMapper.INSTANCE.createcrCreateToTodoRequest(createTodoRequest);
        createTodoUseCase.execute(todo);
        logger.info("Todo created --> " + todo.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GetTodoResponse> getById(@PathVariable @Valid String id) {
        Todo todo = getByIdTodoUseCase.execute(id).orElseThrow(() ->
                new TodoNotFoundException("Todo not found id : " + id));
        GetTodoResponse getTodoResponse = TodoMapper.INSTANCE.todoToGetTodoResponse(todo);
        logger.info("Todo found --> " + todo.toString());
        logger.info("Request in --> " + environment.getProperty("local.server.port"));
        return ResponseEntity.ok(getTodoResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<GetTodoResponse>> getAll() {
        TodoMapper mapper = TodoMapper.INSTANCE;
        List<GetTodoResponse> result = getAllTodosUseCase.execute()
                .stream()
                .map(mapper::todoToGetTodoResponse)
                .collect(Collectors.toList());
        logger.info("gel all executed..");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/test")
    public ResponseEntity<Void> test(String message) {
        try {
            messageProducerService.send(message);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteTodoUseCase.execute(id);
        messageProducerService.send("Todo deleted -> " + id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> changeStatus(@PathVariable String id) {
        completeTodoUseCase.execute(id);
        messageProducerService.send("Status changed -> " + id);
        return ResponseEntity.ok("Status Changed todo -> " + id);
    }

}
