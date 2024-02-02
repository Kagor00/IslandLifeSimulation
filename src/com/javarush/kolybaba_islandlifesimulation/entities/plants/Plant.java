package com.javarush.kolybaba_islandlifesimulation.entities.plants;

import com.javarush.kolybaba_islandlifesimulation.entities.Organism;

public abstract class Plant extends Organism {

    public Plant(int id, double weight) {
        super(id, weight, 200);
    }
}
