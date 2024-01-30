package com.javarush.islandsimulation.management;

import com.javarush.islandsimulation.island.Island;

public class Controller {
    private static final PopulationService POPULATION_SERVICE = new PopulationService();
    private static final SimulationService SIMULATION_SERVICE = new SimulationService();

    static void startProgram() {
        Island island = initializeIsland();
        populateIslandWithAnimals(island);
        runLimitedSimulation(island);
    }

    private static Island initializeIsland() {
        int rows = CLI.promptForInt("Введiть кiлькiсть рядкiв на островi: ");
        int columns = CLI.promptForInt("Введiть кiлькiсть стовпцiв на островi ");
        return new Island(rows, columns);
    }

    private static void populateIslandWithAnimals(Island island) {
        System.out.println("Заповнiть початкову кiлькiсть тварин кожного виду на островi");
        POPULATION_SERVICE.wolvesCreator(CLI.promptForInt("Кiлькiсть вовкiв: "), island);
        POPULATION_SERVICE.boasCreator(CLI.promptForInt("Кiлькiсть удавiв: "), island);
        POPULATION_SERVICE.bearsCreator(CLI.promptForInt("Кiлькiсть ведмедiв: "), island);
        POPULATION_SERVICE.foxesCreator(CLI.promptForInt("Кiлькiсть лисиць: "), island);
        POPULATION_SERVICE.eaglesCreator(CLI.promptForInt("Кiлькiсть орлiв: "), island);
        POPULATION_SERVICE.horsesCreator(CLI.promptForInt("Кiлькiсть коней: "), island);
        POPULATION_SERVICE.deerCreator(CLI.promptForInt("Кiлькiсть оленiв: "), island);
        POPULATION_SERVICE.rabbitsCreator(CLI.promptForInt("Кiлькiсть кроликiв: "), island);
        POPULATION_SERVICE.mousesCreator(CLI.promptForInt("Кiлькiсть мишей: "), island);
        POPULATION_SERVICE.goatsCreator(CLI.promptForInt("Кiлькiсть кiз: "), island);
        POPULATION_SERVICE.sheepCreator(CLI.promptForInt("Кiлькiсть овець: "), island);
        POPULATION_SERVICE.boarsCreator(CLI.promptForInt("Кiлькiсть кабанiв: "), island);
        POPULATION_SERVICE.buffaloesCreator(CLI.promptForInt("Кiлькiсть буйволiв: "), island);
        POPULATION_SERVICE.ducksCreator(CLI.promptForInt("Кiлькiсть качок: "), island);
        POPULATION_SERVICE.caterpillarsCreator(CLI.promptForInt("Кiлькiсть гусенi: "), island);
    }

    private static void runLimitedSimulation(Island island) {
        int daysCount = CLI.promptForInt("Введiть кiлькiсть днiв симуляцiї життя на островi: ");
        System.out.println("Зачекайте поки завершиться симуляцiя...");
        for (int i = 0; i < daysCount; i++) {
            Controller.SIMULATION_SERVICE.plantGrowth(island);
            Controller.SIMULATION_SERVICE.animalLifeSimulation(island);
        }
        System.out.println("Симуляцiю завершено. ");
        System.out.println("Статистика популяцiї тварин на островi по завершенню симуляцiї: ");
        Controller.POPULATION_SERVICE.getCountAnimalsOnIsland(island);
    }
}

