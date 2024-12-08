package com.example.pets_project.services;

import com.example.pets_project.dto.HouseholdDTO;
import com.example.pets_project.entities.Household;
import com.example.pets_project.repositories.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;

    @Autowired
    public HouseholdServiceImpl(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    @Override
    public List<Household> findAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Optional<Household> findHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode);
    }

    @Override
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Override
    public Household createHousehold(HouseholdDTO householdDTO) {
        Household household = new Household();
        household.setEircode(householdDTO.eircode());
        household.setNumberOfOccupants(householdDTO.numberOfOccupants());
        household.setMaxNumberOfOccupants(householdDTO.maxNumberOfOccupants());
        household.setOwnerOccupied(householdDTO.ownerOccupied());
        return householdRepository.save(household);
    }

    @Override
    public void deleteHousehold(String eircode) {
        householdRepository.deleteById(eircode);
    }
}
