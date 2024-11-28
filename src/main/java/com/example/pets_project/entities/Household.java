package com.example.pets_project.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "houseHold")
@Data
@NoArgsConstructor
public class Household {
    @Id
    private String eircode;

    @Column(nullable = false)
    private int numberOfOccupants;

    @Column(nullable = false)
    private int maxNumberOfOccupants;

    @Column(nullable = false)
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets;
}
