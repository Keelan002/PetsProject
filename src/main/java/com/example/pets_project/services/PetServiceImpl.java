package com.example.pets_project.services;

import com.example.pets_project.Exceptions.PetNotFoundException;
import com.example.pets_project.dto.PetDTO;
import com.example.pets_project.entities.Pet;
import com.example.pets_project.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pets_project.Exceptions.HandleValidationExceptions;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> getPet(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public Pet createPet(PetDTO petDTO) {
        Pet pet = new Pet();
        validatePet(pet);
        pet.setName(petDTO.name());
        pet.setAnimalType(petDTO.animalType());
        pet.setBreed(petDTO.breed());
        pet.setAge(petDTO.age());
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet changePetName(Long id, String name) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("Pet not found with id: " + id));
        pet.setName(name);
        return petRepository.save(pet);
    }

    private void validatePet(Pet pet) {
        if (pet == null) {
            throw new HandleValidationExceptions("Pet cannot be null");
        }
        if (pet.getName() == null || pet.getName().trim().isEmpty()) {
            throw new HandleValidationExceptions("Pet name cannot be empty");
        }
        if (pet.getAnimalType() == null || pet.getAnimalType().trim().isEmpty()) {
            throw new HandleValidationExceptions("Animal type cannot be empty");
        }
        if (pet.getBreed() == null || pet.getBreed().trim().isEmpty()) {
            throw new HandleValidationExceptions("Breed cannot be empty");
        }
        if (pet.getAge() == 0 || pet.getAge() < 0) {
            throw new HandleValidationExceptions("Age must be a non-negative number");
        }
    }
}
