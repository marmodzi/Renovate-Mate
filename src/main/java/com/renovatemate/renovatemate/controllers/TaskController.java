package com.renovatemate.renovatemate.controllers;

import com.renovatemate.renovatemate.entities.Task;
import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.services.TaskService;
import com.renovatemate.renovatemate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    // view -  "modyfikuj swoje zadania w bazie danych"

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String getTasks(Authentication authentication, Model model) {
        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("tasks", taskService.findAllByUser(user));
        model.addAttribute("task", new Task());
        return "tasks";
    }

    @PostMapping
    public String addTask(Authentication authentication, Task task) {
        User user = userService.findByUsername(authentication.getName());
        taskService.save(task, user);
        return "redirect:/tasks";
    }
}