package com.example.pets_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public record HouseholdDTO(
        @NotBlank(message = "Eircode is required")
        String eircode,

        @NotNull(message = "Number of occupants is required")
        Integer numberOfOccupants,

        @NotNull(message = "Max number of occupants is required")
        Integer maxNumberOfOccupants,

        @NotNull(message = "Owner occupied status is required")
        Boolean ownerOccupied
) {}
