package com.example.springBootToDoApplication.services;

import com.example.springBootToDoApplication.models.TodoItem;
import com.example.springBootToDoApplication.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

/**
 * @author malisahin
 * @since 10/5/2023
 */
@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }
    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());
        }
        todoItem.setUpdatedAt((Instant.now()));
        return todoItemRepository.save(todoItem);
    }
    public void delete(TodoItem todoItem){
        todoItemRepository.delete(todoItem);
    }
}
