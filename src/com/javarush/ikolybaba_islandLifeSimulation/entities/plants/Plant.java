package com.javarush.ikolybaba_islandLifeSimulation.entities.plants;

import com.javarush.ikolybaba_islandLifeSimulation.entities.Organism;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class Plant extends Organism {

    public Plant(int id, double weight) {
        super(id, weight, 200);
    }
}
