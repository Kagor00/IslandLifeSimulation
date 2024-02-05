package com.javarush.kolybaba_islandlifesimulation.management;

import com.javarush.kolybaba_islandlifesimulation.entities.animal.Animal;
import com.javarush.kolybaba_islandlifesimulation.entities.plants.Plant;
import com.javarush.kolybaba_islandlifesimulation.entities.plants.pantsservice.PlantsCreator;
import com.javarush.kolybaba_islandlifesimulation.island.Island;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;



public class SimulationService {

    // 20% імовірність виростання рандомної рослини в кожній клітинці
    private static final double PLANTS_GROWTH_PROBABILITY = 0.20;


    void animalLifeSimulation(Island island) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int rows = island.getRows();
        int columns = island.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int finalI = i;
                int finalJ = j;
                executorService.submit(() -> {
                    List<Animal> animalsInCell = island.getAllAnimalsFromCell(finalI, finalJ);
                    for (Animal animal : animalsInCell) {
                        animal.move(island);
                        animal.findFood(island);
                        animal.reproduce(island);
                        animal.deplete(island);
                    }
                });
            }
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    void plantGrowth(Island island) {
        int rows = island.getRows();
        int columns = island.getColumns();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Plant randomPlant = PlantsCreator.createRandomPlant();
                final int finalI = i;
                final int finalJ = j;
                int plantsCount = island.getCountOfOrganismTypeOnCell(finalI, finalJ, randomPlant);
                int maxCount = randomPlant.getMaxCount();
                executorService.submit(() -> {
                    if (isGrowthProbabilityValid() && plantsCount < maxCount) {
                        island.addOrganismToCell(finalI,finalJ, randomPlant);
                    }
                });
            }
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private boolean isGrowthProbabilityValid() {
        return ThreadLocalRandom.current().nextDouble() < PLANTS_GROWTH_PROBABILITY;
    }
}
