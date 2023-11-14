package com.todolist.todolist.repository;

import com.todolist.todolist.core.entity.Todo;
import com.todolist.todolist.infrastructure.persistance.repository.TodoRepositoryJpa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TodoRepositoryTest {

    private final TodoRepositoryJpa todoRepositoryJpa;


    @Value("${deneme-value}")
    private String value;

    @Autowired
    public TodoRepositoryTest(TodoRepositoryJpa todoRepositoryJpa) {
        this.todoRepositoryJpa = todoRepositoryJpa;
    }


    @Test
    public void TodoRepository_Save_ReturnsSavedReview() {
        System.out.println("Value ---> " + value);
        Todo todo = Todo.builder()
                .creationDate(LocalDateTime.now())
                .finishDate(LocalDateTime.now())
                .status(false)
                .description("deneme")
                .build();

        Todo returnedValue = todoRepositoryJpa.save(todo);

        Assertions.assertThat(returnedValue).isNotNull();
        Assertions.assertThat(returnedValue.getId()).isNotNull();
    }


    @Test
    public void TodoRepository_FindAll_ReturnsMoreThenOneTodo(){
        Todo todo1 = Todo.builder()
                .creationDate(LocalDateTime.now())
                .finishDate(LocalDateTime.now())
                .status(false)
                .description("deneme")
                .build();
        Todo todo2 = Todo.builder()
                .creationDate(LocalDateTime.now())
                .finishDate(LocalDateTime.now())
                .status(false)
                .description("deneme 2")
                .build();

        todoRepositoryJpa.save(todo1);
        todoRepositoryJpa.save(todo2);
        List<Todo> result = todoRepositoryJpa.findAll();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isGreaterThan(1);

    }





}
