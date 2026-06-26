package com.petproject.task_management.controller;

import com.petproject.task_management.dto.TaskRequestDTO;
import com.petproject.task_management.dto.TaskResponseDTO;
import com.petproject.task_management.model.Task;
import com.petproject.task_management.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDTO create(@RequestBody TaskRequestDTO dto) {
        return taskService.create(dto);
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTask() {
        return taskService.getAllTask();
    }
}
