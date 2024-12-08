package com.example.pets_project.Exceptions;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(String message) {
        super(message);  // Pass the message to the superclass constructor
    }

    // Optionally, you can add constructors with cause or other parameters if needed
    public PetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
