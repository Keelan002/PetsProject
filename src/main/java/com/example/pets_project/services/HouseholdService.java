package com.example.pets_project.services;

import com.example.pets_project.entities.Household;
import com.example.pets_project.entities.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HouseholdService {

    Optional<Pet> findHouseholdByEircode(String eircode);

    Optional<Household> findHouseholdWithPets(String eircode);

    List<Household> findHouseholdsWithNoPets();
}
