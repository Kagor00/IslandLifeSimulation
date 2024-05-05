package com.javarush.ikolybaba_islandLifeSimulation.management;

class Runner {
    public static void main(String[] args) {
        IslandService islandService = new IslandService(new PopulationService(), new SimulationService());
        islandService.initializeAndPopulate();
    }
}
