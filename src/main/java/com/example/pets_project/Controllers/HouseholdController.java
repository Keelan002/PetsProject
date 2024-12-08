package com.example.pets_project.Controllers;

import com.example.pets_project.Exceptions.HouseholdNotFoundException;
import com.example.pets_project.Handlers.GlobalHandlers;
import com.example.pets_project.dto.HouseholdDTO;
import com.example.pets_project.entities.Household;
import com.example.pets_project.services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/households")
public class HouseholdController {

    private final HouseholdService householdService;

    @Autowired
    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    // Get all households
    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.findAllHouseholds();
    }

    // Get a household by Eircode
    @GetMapping("/{eircode}")
    public Household getHousehold(@PathVariable String eircode) {
        return householdService.findHouseholdByEircode(eircode)
                .orElseThrow(() -> new HouseholdNotFoundException("Household not found with eircode: " + eircode));
    }

    // Get households with no pets
    @GetMapping("/no-pets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.findHouseholdsWithNoPets();
    }

    // Create a new household
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Household createHousehold(@Valid @RequestBody HouseholdDTO householdDTO) {
        return householdService.createHousehold(householdDTO);
    }

    // Delete a household
    @DeleteMapping("/{eircode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
    }
}
