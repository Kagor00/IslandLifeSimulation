package com.javarush.kolybaba_islandlifesimulation.entities.animal.predators;

import com.javarush.kolybaba_islandlifesimulation.entities.animal.Animal;
import com.javarush.kolybaba_islandlifesimulation.entities.animal.Gender;

public abstract class Predator extends Animal {
    public Predator(int id, double weight, int maxCount, int maxSpeed, double saturation, Gender gender) {
        super(id, weight, maxCount, maxSpeed, saturation, gender);
    }
}
