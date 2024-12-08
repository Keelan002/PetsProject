package com.example.pets_project.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class HandleValidationExceptions extends RuntimeException{

    public HandleValidationExceptions(String message) {
        super(message);
    }
}
