package com.curso.taskapp.dto.in;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskInDTO {
    private String title;
    private String description;
    private LocalDateTime eta;
}
