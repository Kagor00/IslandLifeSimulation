package com.javarush.ikolybaba_islandLifeSimulation.entities.plants.pantsservice;

import com.javarush.ikolybaba_islandLifeSimulation.entities.plants.*;

import java.util.concurrent.ThreadLocalRandom;

public class PlantsCreator {
    public static Plant createRandomPlant() {
        int randomType = ThreadLocalRandom.current().nextInt(4);
        return switch (randomType) {
            case 0 -> new Grass();
            case 1 -> new Carrot();
            case 2 -> new Radish();
            default -> new Cabbage();
        };
    }
}
