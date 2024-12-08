package com.example.pets_project.services;

import com.example.pets_project.dto.HouseholdDTO;
import com.example.pets_project.entities.Household;

import java.util.List;
import java.util.Optional;

public interface HouseholdService {

    List<Household> findAllHouseholds();

    Optional<Household> findHouseholdByEircode(String eircode);

    List<Household> findHouseholdsWithNoPets();

    Household createHousehold(HouseholdDTO householdDTO);

    void deleteHousehold(String eircode);
}
