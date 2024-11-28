package com.example.pets_project;

import com.example.pets_project.entities.Pet;
import com.example.pets_project.repositories.PetRepository;
import com.example.pets_project.services.PetService;
import com.example.pets_project.services.PetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceImplTest {

    private PetRepository petRepository;
    private PetService petService;

    @BeforeEach
    void setUp() {
        petRepository = mock(PetRepository.class);
        petService = new PetServiceImpl(petRepository);
    }

    @Test
    void testCreatePet() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setAnimalType("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(3);

        when(petRepository.save(Mockito.any(Pet.class))).thenReturn(pet);

        Pet savedPet = petService.createPet(pet);

        assertNotNull(savedPet);
        assertEquals("Buddy", savedPet.getName());
        verify(petRepository, times(1)).save(pet);
    }

    @Test
    void testGetPetById() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Buddy");

        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));

        Pet foundPet = petService.getPetById(1L);

        assertNotNull(foundPet);
        assertEquals("Buddy", foundPet.getName());
    }

    @Test
    void testDeletePetById() {
        when(petRepository.existsById(1L)).thenReturn(true);

        petService.deletePetById(1L);

        verify(petRepository, times(1)).deleteById(1L);
    }
}
