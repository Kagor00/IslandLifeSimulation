package com.javarush.kolybaba_islandlifesimulation.entities.plants.pantsservice;

import com.javarush.kolybaba_islandlifesimulation.entities.plants.*;

import java.util.concurrent.ThreadLocalRandom;

public class PlantsCreator {
    public static Plant createRandomPlant() {
        int randomType = ThreadLocalRandom.current().nextInt(4);
        if (randomType == 0) {
            return new Grass();
        } else if (randomType == 1) {
            return new Carrot();
        } else if (randomType == 2) {
            return new Radish();
        } else {
            return new Cabbage();
        }
    }
}
