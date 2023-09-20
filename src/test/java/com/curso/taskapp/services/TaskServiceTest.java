package com.curso.taskapp.services;

import com.curso.taskapp.mappers.TaskInDTOToTask;
import com.curso.taskapp.persistences.entities.Task;
import com.curso.taskapp.persistences.entities.TaskStatus;
import com.curso.taskapp.persistences.repositories.ITaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
@Component
class TaskServiceTest {

    ITaskRepository repositoryMock = Mockito.mock(ITaskRepository.class);

    @Autowired
    TaskInDTOToTask mapper;

    @BeforeEach
    void setUp() {
        LocalDateTime etaValid = LocalDateTime.of(Calendar.getInstance().get(Calendar.YEAR)+1, 10,15, 5,20);
        Task entity = new Task();

        Task task = new Task();
        task.setTitle("Probando Mock");
        task.setDescription("Probando Test con Mockito");
        task.setEta(etaValid);
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        Mockito.when(repositoryMock.save(entity)).thenReturn(task);

    }

    @Test
    void createTask() {
        LocalDateTime etaValid = LocalDateTime.of(Calendar.getInstance().get(Calendar.YEAR)+1, 10,15, 5,20);

        Task task = new Task();
        task.setTitle("Probando Mock");
        task.setDescription("Probando Test con Mockito");
        task.setEta(etaValid);
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        Task taskReturn = repositoryMock.save(new Task());
        Assertions.assertEquals(true,
                taskReturn.getTitle().equals(task.getTitle()) &&
                taskReturn.getDescription().equals(task.getDescription()) &&
                taskReturn.getTaskStatus().equals(task.getTaskStatus()));

    }

    @AfterEach
    void tearDown() {
        System.out.println("Test Finish with Mocks");
    }

}