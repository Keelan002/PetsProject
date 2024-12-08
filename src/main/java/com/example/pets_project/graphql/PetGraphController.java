package com.example.pets_project.graphql;

import com.example.pets_project.dto.HouseholdDTO;
import com.example.pets_project.entities.Household;
import com.example.pets_project.entities.Pet;
import com.example.pets_project.services.HouseholdService;
import com.example.pets_project.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Optional;

@Controller
public class PetGraphController {

    private PetService petService;
    private HouseholdService householdService;



    public void PetQueryController(PetService petService, HouseholdService householdService) {
        this.petService = petService;
        this.householdService = householdService;
    }

    @QueryMapping
    public Iterable<Household> households() {
        return householdService.findAllHouseholds();
    }

    @QueryMapping
    public Optional<Pet> petsByAnimalType(@Argument Long ID) {
        return petService.getPet(ID);
    }

    @QueryMapping
    public Optional<Household> household(@Argument String eircode) {
        return householdService.findHouseholdByEircode(eircode);
    }

    @MutationMapping
    public Household createHousehold(@Argument HouseholdInput household) {
        return householdService.createHousehold(
                HouseholdDTO.builder()
                        .eircode(household.eircode())
                        .numberOfOccupants(household.numberOfOccupants())
                        .maxNumberOfOccupants(household.maxNumberOfOccupants())
                        .ownerOccupied(household.ownerOccupied())
                        .build()
        );
    }

    @MutationMapping
    public boolean deleteHousehold(@Argument String eircode) {
        householdService.deleteHousehold(eircode);
        return true;
    }

    @MutationMapping
    public boolean deletePet(@Argument Long id) {
        petService.deletePet(id);
        return true;
    }

}
