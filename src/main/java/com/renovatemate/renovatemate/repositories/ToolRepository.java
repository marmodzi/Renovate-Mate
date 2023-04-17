package com.renovatemate.renovatemate.repositories;

import com.renovatemate.renovatemate.entities.Tool;
import com.renovatemate.renovatemate.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToolRepository extends CrudRepository<Tool, Long> {
    List<Tool> findAllByUser(User user);
    Optional<Tool> findByIdAndUser(Long id, User user);
    void deleteByIdAndUser(Long id, User user);
}
