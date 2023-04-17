package com.renovatemate.renovatemate.services;

import com.renovatemate.renovatemate.entities.Tool;
import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.repositories.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {
    private final ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public List<Tool> findAllByUser(User user) {
        return toolRepository.findAllByUser(user);
    }

    public Optional<Tool> findByIdAndUser(Long id, User user) {
        return toolRepository.findByIdAndUser(id, user);
    }

    // at this stage of application, not yet used

    public Tool save(Tool tool, User user) {
        tool.setUser(user);
        return toolRepository.save(tool);
    }

}
