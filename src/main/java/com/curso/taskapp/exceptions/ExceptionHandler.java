package com.curso.taskapp.exceptions;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {TaskException.class })
    protected ResponseEntity<Object> handleConflict(
            TaskException ex, WebRequest request) {
        BodyOfResponse bodyOfResponse = new BodyOfResponse();
        bodyOfResponse.setMessage(ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), ex.getHttpStatus(), request);
    }

    @Data
    private class BodyOfResponse{
        private String message;
    }
}
