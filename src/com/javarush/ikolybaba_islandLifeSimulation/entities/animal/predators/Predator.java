package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.predators;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Animal;
import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;

abstract class Predator extends Animal {
    public Predator(int id, double weight, int maxCount, int maxSpeed, double saturation, Gender gender) {
        super(id, weight, maxCount, maxSpeed, saturation, gender);
    }
}
