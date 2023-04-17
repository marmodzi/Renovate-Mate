package com.renovatemate.renovatemate.services;

import com.renovatemate.renovatemate.entities.TaskTool;
import com.renovatemate.renovatemate.entities.Tool;
import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.repositories.TaskRepository;
import com.renovatemate.renovatemate.repositories.TaskToolRepository;
import com.renovatemate.renovatemate.repositories.ToolRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskToolService {
    private final TaskToolRepository taskToolRepository;
    private final TaskRepository taskRepository;
    private final ToolRepository toolRepository;
    private final UserService userService;

    public TaskToolService(TaskToolRepository taskToolRepository, TaskRepository taskRepository, ToolRepository toolRepository, UserService userService) {
        this.taskToolRepository = taskToolRepository;
        this.taskRepository = taskRepository;
        this.toolRepository = toolRepository;
        this.userService = userService;
    }

    public void save(TaskTool taskTool, Authentication authentication) {
        taskTool.setUser(userService.findByUsername(authentication.getName()));
        taskToolRepository.save(taskTool);
    }

    public List<Tool> findByTaskId(Long taskId) {
        return taskToolRepository.findByTaskId(taskId);
    }

    public List<TaskTool> findAllByUser(User user) {
        return taskToolRepository.findByUser(user);
    }
}
