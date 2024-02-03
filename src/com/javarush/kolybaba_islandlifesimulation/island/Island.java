package com.javarush.kolybaba_islandlifesimulation.island;

import com.javarush.kolybaba_islandlifesimulation.entities.Organism;
import com.javarush.kolybaba_islandlifesimulation.entities.animal.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class Island {
    private final List<List<Cell>> cells;

    public Island(int numRows, int numColumns) {
        cells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < numColumns; j++) {
                row.add(new Cell());
            }
            cells.add(row);
        }
    }

    public void addOrganismToCell(int row, int column, Organism organism) {
        List<Organism> organisms = getAllOrganismsFromCell(row, column);
        if (!organisms.contains(organism)) {
            organisms.add(organism);
        } else {
            throw new IllegalStateException("This cell already has this organism");
        }
    }

    public void removeOrganismFromCell(int row, int column, Organism organism) {
        getAllOrganismsFromCell(row, column).remove(organism);
    }

    public synchronized List<Organism> getAllOrganismsFromCell(int row, int column) {
        return cells.get(row).get(column).organisms;
    }

   public synchronized boolean isAnimalPopulationValid(Island island) {
        int totalAnimalsCount;
        List<Animal> allAnimals = island.getAllAnimalsFromIsland();
        totalAnimalsCount = allAnimals.size();
        return totalAnimalsCount > 1;
    }


    public synchronized int getCountOfOrganismTypeOnCell(int row, int column, Organism organism) {
        List<Organism> organisms = getAllOrganismsFromCell(row, column);
        int count = 0;
        for (Organism org : organisms) {
            if (org != null && org.getClass().equals(organism.getClass())) {
                count++;
            }
        }
        return count;
    }

    public synchronized int[] getPositionOfOrganism(Organism organism) {
        for (int row = 0; row < cells.size(); row++) {
            for (int column = 0; column < cells.get(row).size(); column++) {
                List<Organism> organisms = new ArrayList<>(getAllOrganismsFromCell(row, column));
                if (organisms.contains(organism)) {
                    return new int[]{row, column};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public synchronized List<Animal> getAllAnimalsFromCell(int row, int column) {
        List<Organism> organisms = getAllOrganismsFromCell(row, column);
        return organisms.stream()
                .filter(organism -> organism instanceof Animal)
                .map(organism -> (Animal) organism)
                .collect(Collectors.toList());
    }

    public synchronized List<Animal> getAllAnimalsFromIsland() {
        List<Animal> animals = new ArrayList<>();
        int rows = getRows();
        int columns = getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                animals.addAll(getAllAnimalsFromCell(i, j));
            }
        }
        return animals;
    }


    public int getRows() {
        return getCells().size();
    }

    public int getColumns() {
        return getCells().getFirst().size();
    }


    public boolean isValidCell(int row, int column) {
        return row >= 0 && row < getRows() && column >= 0 && column < getColumns();
    }


    private static class Cell {
        private final List<Organism> organisms;

        private Cell() {
            organisms = new ArrayList<>();
        }
    }
}


