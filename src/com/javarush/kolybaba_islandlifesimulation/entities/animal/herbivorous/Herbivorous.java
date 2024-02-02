package com.javarush.kolybaba_islandlifesimulation.entities.animal.herbivorous;

import com.javarush.kolybaba_islandlifesimulation.entities.animal.Animal;
import com.javarush.kolybaba_islandlifesimulation.entities.animal.Gender;

public abstract class Herbivorous extends Animal {
    public Herbivorous(int id, double weight, int maxCount, int maxSpeed, double saturation, Gender gender) {
        super(id, weight, maxCount, maxSpeed, saturation, gender);
    }
}
