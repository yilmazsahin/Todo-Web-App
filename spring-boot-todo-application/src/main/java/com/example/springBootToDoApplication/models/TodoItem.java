package com.example.springBootToDoApplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author malisahin
 * @since 10/5/2023
 */
@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class TodoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private boolean isComplete;
    private Instant createdAt;
    private Instant updatedAt;

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s',isComplete='%s', createdAt='%s',updatedAt='%s'}",
                id, description, isComplete, createdAt, updatedAt);
    }

}