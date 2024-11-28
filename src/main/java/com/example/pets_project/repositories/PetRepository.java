package com.example.pets_project.repositories;

import com.example.pets_project.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    // Find pets by name (case-insensitive)
    List<Pet> findByNameIgnoreCase(String name);

    // Find pets by animal type
    List<Pet> findByAnimalType(String animalType);

    // Find pets by breed and order by age
    List<Pet> findByBreedOrderByAge(String breed);

    // Get name, animal type, and breed only
    @Query("SELECT p.name, p.animalType, p.breed FROM Pet p")
    List<Object[]> findNameAndBreed();

    // Get statistics (average age and max age)
    @Query("SELECT AVG(p.age), MAX(p.age) FROM Pet p")
    Object[] findAgeStatistics();
}
