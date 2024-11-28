package com.example.pets_project.services;

import com.example.pets_project.entities.Household;
import com.example.pets_project.entities.Pet;
import com.example.pets_project.repositories.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;


    public HouseholdServiceImpl(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    @Override
    public Optional<Pet> findHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode);
    }

    @Override
    public Optional<Household> findHouseholdWithPets(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode);
    }

    @Override
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }
}
