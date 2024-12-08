package com.example.pets_project.Controllers;

import com.example.pets_project.Exceptions.PetNotFoundException;
import com.example.pets_project.dto.PetDTO;
import com.example.pets_project.entities.Pet;
import com.example.pets_project.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Get all pets
    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    // Get a pet by ID
    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id) {
        return petService.getPet(id)
                .orElseThrow(() -> new PetNotFoundException("Pet not found with id: " + id));
    }

    // Create a new pet
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet createPet(@Valid @RequestBody PetDTO petDTO) {
        return petService.createPet(petDTO);
    }

    // Delete a pet
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }

    // Change a pet's name (PATCH)
    @PatchMapping("/{id}/name")
    public Pet changePetName(@PathVariable Long id, @RequestParam String name) {
        return petService.changePetName(id, name);
    }
}
