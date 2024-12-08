package com.example.pets_project.Exceptions;

public class HouseholdNotFoundException extends RuntimeException {

    public HouseholdNotFoundException(String message) {
        super(message);  // Pass the message to the superclass constructor
    }

    // Optionally, you can add constructors with cause or other parameters if needed
    public HouseholdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
