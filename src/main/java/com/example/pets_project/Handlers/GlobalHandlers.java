package com.example.pets_project.Handlers;

import com.example.pets_project.Exceptions.HouseholdNotFoundException;
import com.example.pets_project.Exceptions.PetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandlers {
    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<String> handlePetNotFound(PetNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);  // Return a 404 with the error message
    }

    @ExceptionHandler(HouseholdNotFoundException.class)
    public ResponseEntity<String> handleHouseholdNotFound(HouseholdNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);  // Return a 404 with the error message
    }


}
