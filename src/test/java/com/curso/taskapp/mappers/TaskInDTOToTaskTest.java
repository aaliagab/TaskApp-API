package com.curso.taskapp.mappers;

import com.curso.taskapp.dto.in.TaskInDTO;
import com.curso.taskapp.persistences.entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;

@Component
class TaskInDTOToTaskTest {
    @Autowired
    private TaskInDTOToTask taskInDTOToTask;

    @Test
    void map() {
        taskInDTOToTask = new TaskInDTOToTask();
        LocalDateTime etaValid = LocalDateTime.of(Calendar.getInstance().get(Calendar.YEAR)+1,10,15, 5,20);
        LocalDateTime etaInvalid = LocalDateTime.of(Calendar.getInstance().get(Calendar.YEAR)-1,10,15, 5,20);
        LocalDateTime now = LocalDateTime.now();


        //Invalid
        TaskInDTO taskInDTOInvalid = TaskInDTO
                .builder()
                .title("Tesk")
                .description("Task to test")
                .eta(etaInvalid)
                .build();



        //Valid
        TaskInDTO taskInDTOValid = TaskInDTO
                .builder()
                .title("Tesk")
                .description("Task to test")
                .eta(etaValid)
                .build();
        Task task = taskInDTOToTask.map(taskInDTOValid);
        Assertions.assertNotEquals(task.getCreatedDate(),task.getEta());
        Assertions.assertEquals(true,task.getCreatedDate().isBefore(task.getEta()));
    }
}