package com.javarush.islandsimulation.entities.animal.herbivorous;

import com.javarush.islandsimulation.entities.animal.Animal;
import com.javarush.islandsimulation.entities.animal.Gender;

public abstract class Herbivorous extends Animal {
    public Herbivorous(int id, double weight, int maxCount, int maxSpeed, double saturation, Gender gender) {
        super(id, weight, maxCount, maxSpeed, saturation, gender);
    }
}
