package com.javarush.kolybaba_islandlifesimulation.probability;

import com.javarush.kolybaba_islandlifesimulation.entities.Organism;
import com.javarush.kolybaba_islandlifesimulation.entities.animal.Animal;
import com.javarush.kolybaba_islandlifesimulation.entities.animal.herbivorous.*;
import com.javarush.kolybaba_islandlifesimulation.entities.animal.predators.*;
import com.javarush.kolybaba_islandlifesimulation.entities.plants.Plant;

import java.util.HashMap;
import java.util.Map;

public class ProbabilityMatrix {
    private final Map<Class<? extends Animal>, Map<Class<? extends Organism>, Double>> matrix = new HashMap<>();

    public ProbabilityMatrix() {
        initializeMatrix();
    }

    public double getProbability(Class<? extends Animal> animalClass, Class<? extends Organism> foodClass) {
        Map<Class<? extends Organism>, Double> foodProbabilities = matrix.get(animalClass);
        Double probability = foodProbabilities.get(foodClass);
        if (probability != null) {
            return probability;
        }

        /* Перевіряємо успадковані класи на випадок, коли ключем є батьківський клас,
         оскільки у травоїдних для всіх рослин загалом імовірність однакова */
        for (Map.Entry<Class<? extends Organism>, Double> entry : foodProbabilities.entrySet()) {
            if (entry.getKey().isAssignableFrom(foodClass)) {
                return entry.getValue();
            }
        }
        return 0.0;
    }

    private void setProbability(Class<? extends Animal> animalClass, Class<? extends Organism> foodClass, double probability) {
        matrix.computeIfAbsent(animalClass, k -> new HashMap<>()).put(foodClass, probability);
    }

    private void initializeMatrix() {
        setProbability(Wolf.class, Horse.class, 0.10);
        setProbability(Wolf.class, Deer.class, 0.15);
        setProbability(Wolf.class, Rabbit.class, 0.60);
        setProbability(Wolf.class, Mouse.class, 0.80);
        setProbability(Wolf.class, Goat.class, 0.60);
        setProbability(Wolf.class, Sheep.class, 0.70);
        setProbability(Wolf.class, Boar.class, 0.15);
        setProbability(Wolf.class, Buffalo.class, 0.10);
        setProbability(Wolf.class, Duck.class, 0.40);

        setProbability(Boa.class, Fox.class, 0.15);
        setProbability(Boa.class, Rabbit.class, 0.20);
        setProbability(Boa.class, Mouse.class, 0.40);
        setProbability(Boa.class, Duck.class, 0.10);

        setProbability(Fox.class, Rabbit.class, 0.70);
        setProbability(Fox.class, Mouse.class, 0.90);
        setProbability(Fox.class, Duck.class, 0.60);
        setProbability(Fox.class, Squirrel.class, 0.40);

        setProbability(Bear.class, Boa.class, 0.80);
        setProbability(Bear.class, Horse.class, 0.40);
        setProbability(Bear.class, Deer.class, 0.80);
        setProbability(Bear.class, Deer.class, 0.80);
        setProbability(Bear.class, Mouse.class, 0.90);
        setProbability(Bear.class, Goat.class, 0.70);
        setProbability(Bear.class, Sheep.class, 0.70);
        setProbability(Bear.class, Boar.class, 0.50);
        setProbability(Bear.class, Buffalo.class, 0.20);
        setProbability(Bear.class, Duck.class, 0.10);

        setProbability(Eagle.class, Fox.class, 0.10);
        setProbability(Eagle.class, Rabbit.class, 0.90);
        setProbability(Eagle.class, Mouse.class, 0.90);
        setProbability(Eagle.class, Duck.class, 0.80);


        setProbability(Horse.class, Plant.class, 1.00);
        setProbability(Deer.class, Plant.class, 1.00);
        setProbability(Rabbit.class, Plant.class, 1.00);
        setProbability(Mouse.class, Plant.class, 1.00);
        setProbability(Goat.class, Plant.class, 1.00);
        setProbability(Sheep.class, Plant.class, 1.00);
        setProbability(Boar.class, Plant.class, 1.00);
        setProbability(Boar.class, Mouse.class, 0.50);
        setProbability(Buffalo.class, Plant.class, 1.00);
        setProbability(Duck.class, Plant.class, 1.00);
        setProbability(Squirrel.class, Plant.class, 1.00);
        setProbability(Squirrel.class, Mouse.class, 0.80);
    }
}


