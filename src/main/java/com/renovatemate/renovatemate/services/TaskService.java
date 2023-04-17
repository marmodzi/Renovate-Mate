package com.renovatemate.renovatemate.services;

import com.renovatemate.renovatemate.entities.Task;
import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task save(Task task, User user) {
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    // at this stage of application, not yet used

    public List<Task> findAllByUser(User user) {
        return taskRepository.findByUser(user);
    }
    public Optional<Task> findByIdAndUser(Long id, User user) {
        return taskRepository.findByIdAndUser(id, user);
    }

}