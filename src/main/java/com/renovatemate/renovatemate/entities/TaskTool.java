package com.renovatemate.renovatemate.entities;

import javax.persistence.*;

@Entity
@Table(name = "tasks_tools")
public class TaskTool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Task task;

    @ManyToOne
    private Tool tool;

    @ManyToOne
    private User user;

    public TaskTool(Task task, Tool tool, User user) {
        this.task = task;
        this.tool = tool;
        this.user = user;
    }

    public TaskTool() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
