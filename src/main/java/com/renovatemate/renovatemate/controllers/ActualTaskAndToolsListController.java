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
public class ActualTaskAndToolsListController {
    private final TaskService taskService;
    private final ToolService toolService;
    private final TaskToolService taskToolService;

    public ActualTaskAndToolsListController(TaskService taskService, ToolService toolService, TaskToolService taskToolService) {
        this.taskService = taskService;
        this.toolService = toolService;
        this.taskToolService = taskToolService;
    }

    @GetMapping("/actual-tasks")
    public String getActualTasks(Model model) {
        Iterable<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "actual-tasks";
    }

    @PostMapping("/actual-tasks")
    public String generateToolList(@RequestParam Long taskId, Model model) {
        Task task = taskService.findById(taskId).orElse(null);
        List<Tool> tools = taskToolService.findByTaskId(taskId);

        model.addAttribute("task", task);
        model.addAttribute("tools", tools);
        return "actual-tasks";
    }
}
