package com.javarush.ikolybaba_islandLifeSimulation.management;

import com.javarush.ikolybaba_islandLifeSimulation.island.Island;

class IslandService {
    private final PopulationService populationService;
    private final SimulationService simulationService;

    IslandService(PopulationService populationService, SimulationService simulationService) {
        this.populationService = populationService;
        this.simulationService = simulationService;
    }

    void initializeAndPopulate() {
        Island island = initializeIsland();
        populateIslandWithAnimals(island);

        int promptOptional = CLI.promptForOption();
        processSimulationOption(promptOptional, island);
    }

    private Island initializeIsland() {
        int rows = CLI.promptForInt("Введiть кiлькiсть рядкiв на островi: ");
        int columns = CLI.promptForInt("Введiть кiлькiсть стовпцiв на островi ");
        return new Island(rows, columns);
    }

    private void populateIslandWithAnimals(Island island) {
        System.out.println("Заповнiть початкову кiлькiсть тварин кожного виду на островi");
        populationService.wolvesCreator(CLI.promptForInt("Кiлькiсть вовкiв: "), island);
        populationService.boasCreator(CLI.promptForInt("Кiлькiсть удавiв: "), island);
        populationService.bearsCreator(CLI.promptForInt("Кiлькiсть ведмедiв: "), island);
        populationService.foxesCreator(CLI.promptForInt("Кiлькiсть лисиць: "), island);
        populationService.eaglesCreator(CLI.promptForInt("Кiлькiсть орлiв: "), island);
        populationService.horsesCreator(CLI.promptForInt("Кiлькiсть коней: "), island);
        populationService.deerCreator(CLI.promptForInt("Кiлькiсть оленiв: "), island);
        populationService.rabbitsCreator(CLI.promptForInt("Кiлькiсть кроликiв: "), island);
        populationService.mousesCreator(CLI.promptForInt("Кiлькiсть мишей: "), island);
        populationService.goatsCreator(CLI.promptForInt("Кiлькiсть кiз: "), island);
        populationService.sheepCreator(CLI.promptForInt("Кiлькiсть овець: "), island);
        populationService.boarsCreator(CLI.promptForInt("Кiлькiсть кабанiв: "), island);
        populationService.buffaloesCreator(CLI.promptForInt("Кiлькiсть буйволiв: "), island);
        populationService.ducksCreator(CLI.promptForInt("Кiлькiсть качок: "), island);
        populationService.squirrelsCreator(CLI.promptForInt("Кiлькiсть бiлок: "), island);
    }

    private void processSimulationOption(int promptOptional, Island island) {
        if (promptOptional == CLI.getOPTION_FIRST()) {
            runContinuousSimulation(island);
        } else if (promptOptional == CLI.getOPTION_SECOND()) {
            runLimitedSimulation(island);
        }
    }

    private void runContinuousSimulation(Island island) {
        System.out.println("____________________________________________________________________________________________________________________");
        System.out.println("Зачекайте поки завершиться симуляцiя. Це може зайняти деякий час...");
        System.out.println("____________________________________________________________________________________________________________________");
        int daysCount = 0;

        while (island.isAnimalPopulationValid(island)) {
            simulationService.plantGrowth(island);
            simulationService.animalLifeSimulation(island);
            daysCount++;
        }

        System.out.println("____________________________________________________________________________________________________________________");
        System.out.println("Симуляцiю завершено. Кiлькiсть днiв життя популяцiї: " + daysCount);
        System.out.println("____________________________________________________________________________________________________________________");
    }


    private void runLimitedSimulation(Island island) {
        int daysCount = CLI.promptForInt("Введiть кiлькiсть днiв симуляцiї життя на островi: ");
        System.out.println("Зачекайте поки завершиться симуляцiя. Це може зайняти деякий час...");
        for (int i = 0; i < daysCount; i++) {
            simulationService.plantGrowth(island);
            simulationService.animalLifeSimulation(island);
        }

        System.out.println("____________________________________________________________________________________________________________________");
        System.out.println("Симуляцiю завершено. ");
        System.out.println("____________________________________________________________________________________________________________________");
        System.out.println();
        System.out.println("Статистика популяцiї тварин на островi, " + "день " + daysCount + ":");
        System.out.println();
        populationService.getCountAnimalsOnIsland(island);
        System.out.println("____________________________________________________________________________________________________________________");
    }
}

