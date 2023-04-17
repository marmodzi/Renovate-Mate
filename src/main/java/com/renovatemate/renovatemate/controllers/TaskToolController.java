package com.renovatemate.renovatemate.controllers;

import com.renovatemate.renovatemate.entities.TaskTool;
import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.services.TaskService;
import com.renovatemate.renovatemate.services.TaskToolService;
import com.renovatemate.renovatemate.services.ToolService;
import com.renovatemate.renovatemate.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task-tools")
public class TaskToolController {
    private final TaskToolService taskToolService;
    private final UserService userService;
    private final TaskService taskService;
    private final ToolService toolService;

    public TaskToolController(TaskToolService taskToolService, UserService userService, TaskService taskService, ToolService toolService) {
        this.taskToolService = taskToolService;
        this.userService = userService;
        this.taskService = taskService;
        this.toolService = toolService;

    }

    @GetMapping
    public String getTaskTools(Authentication authentication, Model model) {
        User user = userService.findByUsername(authentication.getName());
        if (user != null) {
            model.addAttribute("tasks", taskService.findAllByUser(user));
            model.addAttribute("tools", toolService.findAllByUser(user));
            model.addAttribute("taskTools", taskToolService.findAllByUser(user));
            model.addAttribute("taskTool", new TaskTool());
        }
        return "task-tools";
    }

    @PostMapping
    public String addTaskTool(Authentication authentication, @ModelAttribute("taskTool") TaskTool taskTool) {
        User user = userService.findByUsername(authentication.getName());
        if (user != null) {
            taskTool.setUser(user);
            taskToolService.save(taskTool, authentication);
        }
        return "redirect:/task-tools";
    }
}
