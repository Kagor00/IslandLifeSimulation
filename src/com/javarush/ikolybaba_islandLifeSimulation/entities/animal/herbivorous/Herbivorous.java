package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Animal;
import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;

abstract class Herbivorous extends Animal {
    Herbivorous(int id, double weight, int maxCount, int maxSpeed, double saturation, Gender gender) {
        super(id, weight, maxCount, maxSpeed, saturation, gender);
    }
}
