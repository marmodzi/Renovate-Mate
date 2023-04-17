package com.renovatemate.renovatemate.repositories;

import com.renovatemate.renovatemate.entities.TaskTool;
import com.renovatemate.renovatemate.entities.Tool;
import com.renovatemate.renovatemate.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskToolRepository extends CrudRepository<TaskTool, Long> {
    List<TaskTool> findByUser(User user);

    @Query("SELECT t.tool FROM TaskTool t WHERE t.task.id = :taskId")
    List<Tool> findByTaskId(@Param("taskId") Long taskId);

    List<Tool> findByTaskIdAndUser(Long taskId, User user);

}
