package com.renovatemate.renovatemate.repositories;

import com.renovatemate.renovatemate.entities.Task;
import com.renovatemate.renovatemate.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByUser(User user);
}
