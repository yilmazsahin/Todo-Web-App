package com.example.springBootToDoApplication.repositories;

import com.example.springBootToDoApplication.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author malisahin
 * @since 10/5/2023
 */

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
