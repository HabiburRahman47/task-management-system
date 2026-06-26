package com.petproject.task_management.service;

import com.petproject.task_management.model.Task;
import com.petproject.task_management.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task create(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepo.save(task);
    }

    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }
}
