package com.javarush.islandsimulation.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Organism {
    private final int id;
    private volatile double weight;
    private final int maxCount;


    public Organism(int id, double weight, int maxCount) {
        this.id = id;
        this.weight = weight;
        this.maxCount = maxCount;
    }


    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    public abstract Organism createNewOrganism();
}
