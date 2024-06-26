package com.javarush.ikolybaba_islandLifeSimulation.management;

import com.javarush.ikolybaba_islandLifeSimulation.entities.Organism;
import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Animal;
import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous.*;
import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.predators.*;
import com.javarush.ikolybaba_islandLifeSimulation.island.Island;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class PopulationService {

    void wolvesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Wolf.createRandomWolf());
        }
    }

    void boasCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Boa.createRandomBoa());
        }
    }

    void foxesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Fox.createRandomFox());
        }
    }

    void bearsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Bear.createRandomBear());
        }
    }

    void eaglesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Eagle.createRandomEagle());
        }
    }

    void horsesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Horse.createRandomHorse());
        }
    }

    void deerCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Deer.createRandomDeer());
        }
    }

    void rabbitsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Rabbit.createRandomRabbit());
        }
    }

    void mousesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Mouse.createRandomMouse());
        }
    }

    void goatsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Goat.createRandomGoat());
        }
    }

    void sheepCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Sheep.createRandomSheep());
        }
    }

    void boarsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Boar.createRandomBoar());
        }
    }

    void buffaloesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Buffalo.createRandomBuffalo());
        }
    }

    void ducksCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Duck.ceateRandomDuck());
        }
    }

    void squirrelsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Squirrel.createRandomSquirrel());
        }
    }

    //Рандомне розміщення популяції з перевіркою ліміту вказаного виду на клітинці
    private void placeOrganismOnRandomCell(Island island, Organism organism) {
        int rows = island.getRows();
        int columns = island.getColumns();
        int maxAttempts = rows * columns;
        int attempts = 0;
        int row;
        int column;
        int countOfOrganismType;
        int maxCount = organism.getMaxCount();

        while (attempts < maxAttempts) {
            row = ThreadLocalRandom.current().nextInt(rows);
            column = ThreadLocalRandom.current().nextInt(columns);
            countOfOrganismType = island.getCountOfOrganismTypeOnCell(row, column, organism);

            if (countOfOrganismType < maxCount) {
                island.addOrganismToCell(row, column, organism);
                break;
            }
            attempts++;
        }
    }

    void getCountAnimalsOnIsland(Island island) {
        int wolvesCount = 0;
        int boasCount = 0;
        int bearsCount = 0;
        int foxesCount = 0;
        int eaglesCount = 0;
        int horsesCount = 0;
        int deerCount = 0;
        int rabbitsCount = 0;
        int mousesCount = 0;
        int goatsCount = 0;
        int sheepCount = 0;
        int boarsCount = 0;
        int buffaloesCount = 0;
        int ducksCount = 0;
        int squirrelsCount = 0;
        List<Animal> allAnimals = island.getAllAnimalsFromIsland();

        for (Organism organism : allAnimals) {
            if (organism instanceof Wolf) {
                wolvesCount++;
            } else if (organism instanceof Boa) {
                boasCount++;
            } else if (organism instanceof Bear) {
                bearsCount++;
            } else if (organism instanceof Fox) {
                foxesCount++;
            } else if (organism instanceof Eagle) {
                eaglesCount++;
            } else if (organism instanceof Horse) {
                horsesCount++;
            } else if (organism instanceof Deer) {
                deerCount++;
            } else if (organism instanceof Rabbit) {
                rabbitsCount++;
            } else if (organism instanceof Mouse) {
                mousesCount++;
            } else if (organism instanceof Goat) {
                goatsCount++;
            } else if (organism instanceof Sheep) {
                sheepCount++;
            } else if (organism instanceof Boar) {
                boarsCount++;
            } else if (organism instanceof Buffalo) {
                buffaloesCount++;
            } else if (organism instanceof Duck) {
                ducksCount++;
            } else if (organism instanceof Squirrel) {
                squirrelsCount++;
            }
        }

        System.out.println("Кiлькiсть вовкiв: " + wolvesCount);
        System.out.println("Кiлькiсть удавiв: " + boasCount);
        System.out.println("Кiлькiсть лисиць: " + foxesCount);
        System.out.println("Кiлькiсть ведмедiв: " + bearsCount);
        System.out.println("Кiлькiсть орлiв: " + eaglesCount);
        System.out.println("Кiлькiсть коней: " + horsesCount);
        System.out.println("Кiлькiсть оленiв: " + deerCount);
        System.out.println("Кiлькiсть кроликiв: " + rabbitsCount);
        System.out.println("Кiлькiсть мишей: " + mousesCount);
        System.out.println("Кiлькiсть кiз: " + goatsCount);
        System.out.println("Кiлькiсть овець: " + sheepCount);
        System.out.println("Кiлькiсть кабанiв: " + boarsCount);
        System.out.println("Кiлькiсть буйволiв: " + buffaloesCount);
        System.out.println("Кiлькiсть качок: " + ducksCount);
        System.out.println("Кiлькiсть бiлок: " + squirrelsCount);
    }
}
