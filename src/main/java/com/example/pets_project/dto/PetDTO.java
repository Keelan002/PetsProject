package com.example.pets_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Animal type is required")
        String animalType,

        @NotBlank(message = "Breed is required")
        String breed,

        @NotNull(message = "Age is required")
        Integer age
) {}
