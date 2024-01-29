package com.javarush.islandsimulation.entities.plants;

import com.javarush.islandsimulation.entities.Organism;

public abstract class Plant extends Organism {

    public Plant(int id, double weight) {
        super(id, weight, 200);
    }
}
