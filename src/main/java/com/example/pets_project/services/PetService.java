package com.example.pets_project.services;

import com.example.pets_project.dto.PetDTO;
import com.example.pets_project.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    List<Pet> getAllPets();

    Optional<Pet> getPet(Long id);

    Pet createPet(PetDTO petDTO);

    void deletePet(Long id);

    Pet changePetName(Long id, String name);
}
