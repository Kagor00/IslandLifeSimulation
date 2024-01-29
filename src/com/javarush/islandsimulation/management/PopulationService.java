package com.javarush.islandsimulation.management;

import com.javarush.islandsimulation.entities.Organism;
import com.javarush.islandsimulation.entities.animal.Animal;
import com.javarush.islandsimulation.entities.animal.herbivorous.*;
import com.javarush.islandsimulation.entities.animal.predators.*;
import com.javarush.islandsimulation.island.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PopulationService {
    public void wolvesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Wolf.createRandomWolf());
        }
    }

    public void boasCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Boa.createRandomBoa());
        }
    }

    public void foxesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Fox.createRandomFox());
        }
    }

    public void bearsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Bear.createRandomBear());
        }
    }

    public void eaglesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Eagle.createRandomEagle());
        }
    }

    public void horsesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Horse.createRandomHorse());
        }
    }

    public void deerCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Deer.createRandomDeer());
        }
    }

    public void rabbitsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Rabbit.createRandomRabbit());
        }
    }

    public void mousesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Mouse.createRandomMouse());
        }
    }

    public void goatsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Goat.createRandomGoat());
        }
    }

    public void sheepCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Sheep.createRandomSheep());
        }
    }

    public void boarsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Boar.createRandomBoar());
        }
    }

    public void buffaloesCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Buffalo.createRandomBuffalo());
        }
    }

    public void ducksCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Duck.ceateRandomDuck());
        }
    }

    public void caterpillarsCreator(int count, Island island) {
        for (int i = 0; i < count; i++) {
            placeOrganismOnRandomCell(island, Caterpillar.createRandomCaterpillar());
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
            countOfOrganismType = island.getCountOfOrganismType(row, column, organism);

            if (countOfOrganismType < maxCount) {
                island.addOrganismToCell(row, column, organism);
                break;
            }
            attempts++;
        }
    }

    public synchronized void getCountAnimalsOnIsland(Island island) {
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
        int caterpillarsCount = 0;

        List<Animal> allAnimals = new ArrayList<>(island.getAllAnimalsFromIsland());

        for (Organism organism : allAnimals) {
            if (organism instanceof Wolf) {
                wolvesCount++;
            } else if (organism instanceof Boa) {
                boasCount++;
            } else if (organism instanceof Fox) {
                foxesCount++;
            } else if (organism instanceof Bear) {
                bearsCount++;
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
            } else if (organism instanceof Caterpillar) {
                caterpillarsCount++;
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
        System.out.println("Кiлькiсть гусенi: " + caterpillarsCount);

    }

//    public void getCountPlantsOnIsland(Island island) {
//        List<Plant> plants = island.getAllPlantsFromIsland();
//        int plantsCount = plants.size();
//        System.out.println("Кількість рослин: " + plantsCount);
//    }
}
