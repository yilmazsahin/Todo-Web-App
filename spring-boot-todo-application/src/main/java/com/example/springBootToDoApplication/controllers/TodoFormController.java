package com.example.springBootToDoApplication.controllers;

//import ch.qos.logback.core.model.Model;

import org.springframework.ui.Model;

import com.example.springBootToDoApplication.models.TodoItem;
import com.example.springBootToDoApplication.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 * @author malisahin
 * @since 10/5/2023
 */

@Controller
public class TodoFormController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "new-todo-item";
    }
    //    th:field="*{description}"

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setComplete(todoItem.isComplete());
        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService.getById(id).orElseThrow(() ->
                new IllegalArgumentException("TodoItem id: " + id + " not found"));
        todoItemService.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService.getById(id).orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + "not found."));
        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = todoItemService.
                getById(id).
                orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
        item.setComplete(todoItem.isComplete());
        item.setDescription(todoItem.getDescription());
        todoItemService.save(item);
        return "redirect:/";
    }
}

