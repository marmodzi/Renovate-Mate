package com.renovatemate.renovatemate.controllers;

import com.renovatemate.renovatemate.entities.Task;
import com.renovatemate.renovatemate.entities.Tool;
import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.services.TaskService;
import com.renovatemate.renovatemate.services.TaskToolService;
import com.renovatemate.renovatemate.services.ToolService;
import com.renovatemate.renovatemate.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/actual-tasks")
public class ActualTaskAndToolsListController {
    private final TaskService taskService;
    private final ToolService toolService;
    private final TaskToolService taskToolService;
    private final UserService userService;

    public ActualTaskAndToolsListController(TaskService taskService, ToolService toolService, TaskToolService taskToolService, UserService userService) {
        this.taskService = taskService;
        this.toolService = toolService;
        this.taskToolService = taskToolService;
        this.userService = userService;
    }

    @GetMapping
    public String getActualTasks(Authentication authentication, Model model) {
        User user = userService.findByUsername(authentication.getName());
        Iterable<Task> tasks = taskService.findAllByUser(user);
        model.addAttribute("tasks", tasks);
        return "actual-tasks";
    }

    @PostMapping
    public String generateToolList(Authentication authentication, @RequestParam Long taskId, Model model) {
        User user = userService.findByUsername(authentication.getName());
        Task task = taskService.findByIdAndUser(taskId, user).orElse(null);
        List<Tool> tools = taskToolService.findByTaskIdAndUser(taskId, user);

        model.addAttribute("task", task);
        model.addAttribute("tools", tools);
        return "actual-tasks";
    }
}
