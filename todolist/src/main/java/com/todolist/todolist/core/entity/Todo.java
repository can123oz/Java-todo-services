package com.todolist.todolist.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Table(name = "todos")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    @NotNull
    @Size(max = 20, min = 2, message = "Todo description has to be 2 to 20 characters")
    private String description;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;

    @Column(name = "finishDate")
    private LocalDateTime finishDate;

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", creationDate=" + creationDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
