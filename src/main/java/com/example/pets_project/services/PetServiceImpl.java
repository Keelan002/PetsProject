package com.example.pets_project.services;

import com.example.pets_project.entities.Pet;
import com.example.pets_project.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        if (pet.getName() == null || pet.getAnimalType() == null || pet.getBreed() == null) {
            throw new IllegalArgumentException("Pet details cannot be null");
        }
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet with ID " + id + " not found"));
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet with ID " + id + " not found"));

        existingPet.setName(pet.getName());
        existingPet.setAnimalType(pet.getAnimalType());
        existingPet.setBreed(pet.getBreed());
        existingPet.setAge(pet.getAge());

        return petRepository.save(existingPet);
    }

    @Override
    public void deletePetById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new IllegalArgumentException("Pet with ID " + id + " does not exist");
        }
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetsByName(String name) {
        List<Pet> pets = petRepository.findByNameIgnoreCase(name);
        if (pets.isEmpty()) {
            throw new IllegalArgumentException("No pets found with name " + name);
        }
        petRepository.deleteAll(pets);
    }

    @Override
    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalType(animalType);
    }

    @Override
    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findByBreedOrderByAge(breed);
    }

    @Override
    public List<Object[]> getNameAndBreed() {
        return petRepository.findNameAndBreed();
    }

    @Override
    public Object[] getPetStatistics() {
        return petRepository.findAgeStatistics();
    }
}
