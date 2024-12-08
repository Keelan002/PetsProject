package com.example.pets_project.graphql;

record HouseholdInput(
        String eircode,
        Integer numberOfOccupants,
        Integer maxNumberOfOccupants,
        Boolean ownerOccupied
) {}
