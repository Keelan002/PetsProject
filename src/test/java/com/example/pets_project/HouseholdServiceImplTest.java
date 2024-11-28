package com.example.pets_project;

import com.example.pets_project.entities.Household;
import com.example.pets_project.repositories.HouseholdRepository;
import com.example.pets_project.repositories.PetRepository;
import com.example.pets_project.services.HouseholdService;
import com.example.pets_project.services.HouseholdServiceImpl;
import com.example.pets_project.services.PetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class HouseholdServiceImplTest {

    private HouseholdRepository householdRepository;
    private HouseholdService householdService;

    @BeforeEach
    void setUp() {
        householdRepository = mock(HouseholdRepository.class);
        householdService = new HouseholdServiceImpl(householdRepository);
    }

    @Test
    void testFindHouseholdWithPets() {
        Household household = householdService.findHouseholdWithPets("D02XY45").orElseThrow();
        assertNotNull(household);
        assertNotNull(household.getPets());
    }

    @Test
    void testFindHouseholdsWithNoPets() {
        List<Household> households = householdService.findHouseholdsWithNoPets();
        assertTrue(households.size() > 0);
    }
}
