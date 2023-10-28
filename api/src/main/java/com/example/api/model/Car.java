package com.example.api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String color;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Engine engine;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Setter(AccessLevel.NONE)
    private List<EquipmentOption> equipmentOptions = new ArrayList<>();

    public Car(String name, String color, Engine engine, List<EquipmentOption> equipmentOptions) {
        this.name = name;
        this.color = color;
        this.engine = engine;
        this.equipmentOptions = equipmentOptions;
    }

}
