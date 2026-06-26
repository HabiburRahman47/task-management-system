package com.petproject.task_management.service;

import com.petproject.task_management.dto.TaskRequestDTO;
import com.petproject.task_management.dto.TaskResponseDTO;
import com.petproject.task_management.model.Task;
import com.petproject.task_management.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public TaskResponseDTO create(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        task.setTitle(taskRequestDTO.title);
        task.setDescription(taskRequestDTO.description);
        task.setStatus(taskRequestDTO.status);
        task.setCreatedAt(LocalDateTime.now());
        Task savedTask = taskRepo.save(task);
        return mapToDTO(savedTask);
    }

    public List<TaskResponseDTO> getAllTask() {
        return taskRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO mapToDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.id = task.getId();
        dto.title = task.getTitle();
        dto.description = task.getDescription();
        dto.status = task.getStatus();
        dto.createdAt = task.getCreatedAt();
        return dto;
    }
}
