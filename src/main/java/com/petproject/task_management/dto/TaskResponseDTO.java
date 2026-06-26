package com.petproject.task_management.dto;

import java.time.LocalDateTime;

public class TaskResponseDTO {
    public Long id;
    public String title;
    public String description;
    public String status;
    public LocalDateTime createdAt;
}
