package com.javarush.kolybaba_islandlifesimulation.entities.animal;

import com.javarush.kolybaba_islandlifesimulation.entities.Organism;
import com.javarush.kolybaba_islandlifesimulation.entities.activities.Depletion;
import com.javarush.kolybaba_islandlifesimulation.entities.activities.Movable;
import com.javarush.kolybaba_islandlifesimulation.entities.activities.Nutrition;
import com.javarush.kolybaba_islandlifesimulation.entities.activities.Reproducible;
import com.javarush.kolybaba_islandlifesimulation.island.Island;
import com.javarush.kolybaba_islandlifesimulation.probability.ProbabilityMatrix;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public abstract class Animal extends Organism implements Movable, Nutrition, Reproducible, Depletion {
    private static final int DIRECTIONS_COUNT = 8;
    private final int maxSpeed;
    private final Gender gender;
    private final double saturation;
    private final ProbabilityMatrix probabilityMatrix = new ProbabilityMatrix();
    //перевірка тварини, яка розмножилась, щоб одна пара тварин розмножувалась лише один раз
    @Setter
    private boolean hasReproduced = false;


    public Animal(int id, double weight, int maxCount, int maxSpeed, double saturation, Gender gender) {
        super(id, weight, maxCount);
        this.maxSpeed = maxSpeed;
        this.saturation = saturation;
        this.gender = gender;
    }


    @Override
    public void move(Island island) {
        int[] position = island.getPositionOfOrganism(this);

        int attempt = 0;

        //цикл на випадок, якщо не вийшло переміститись з першого разу
        while (attempt < DIRECTIONS_COUNT) {
            int[] newPosition = calculateNewPosition(position);
            if (isValidPlacing(island, newPosition)) {
                performMove(island, position, newPosition, this);
                return;
            }
            attempt++;
        }
    }

    public synchronized void findFood(Island island) {
        int[] position = island.getPositionOfOrganism(this);
        List<Organism> organisms = island.getAllOrganismsFromCell(position[0], position[1]);
        double weightFood = 0;
        double probability;
        double random;
        for (Organism food : organisms) {
            probability = probabilityMatrix.getProbability(this.getClass(), food.getClass());
            random = ThreadLocalRandom.current().nextDouble();
            if (random <= probability && probability > 0) {
                weightFood = food.getWeight();
                island.removeOrganismFromCell(position[0], position[1], food);
                break;
            }
        }

        /* якщо вага спійманої тварини більша за насиченість, додаємо насиченість,
        якщо менша - додаємо вагу спійманої тварини */
        if (weightFood >= this.saturation) {
            setWeight(getWeight() + this.saturation);
        } else {
            setWeight(getWeight() + weightFood);
        }
    }


    @Override
    public synchronized void reproduce(Island island) {
        int[] position = island.getPositionOfOrganism(this);
        int row = position[0];
        int column = position[1];
        Animal firstAnimal = this;
        Animal newAnimal;

        List<Animal> animals = island.getAllAnimalsFromCell(row, column);
        for (Animal secondAnimal : animals) {
            if (isValidReproduce(firstAnimal, secondAnimal) && isValidPlacing(island, position)) {
                newAnimal = (Animal) this.createNewOrganism();
                island.addOrganismToCell(row, column, newAnimal);
                firstAnimal.setHasReproduced(true);
                secondAnimal.setHasReproduced(true);
                break;
            }
        }
    }

    @Override
    public void deplete(Island island) {
        /* від ваги віднімається насиченість, таким чином тварина постійно повинна їсти,
        якщо вага дійде до нуля, тварина помре */
        this.setWeight(this.getWeight() - this.getSaturation());
        int[] position = island.getPositionOfOrganism(this);
        int row = position[0];
        int column = position[1];
        if (this.getWeight() <= 0) {
            island.removeOrganismFromCell(row, column, this);
        }
    }

    private int[] calculateNewPosition(int[] currentPosition) {
        int maxSpeed = this.getMaxSpeed();

        int direction = ThreadLocalRandom.current().nextInt(DIRECTIONS_COUNT); //обираємо один з восьми напрямків руху
        int row = currentPosition[0];
        int column = currentPosition[1];
        int steps = ThreadLocalRandom.current().nextInt(maxSpeed) + 1;
        //Напрямки (по прямій і по діагоналі)
        switch (direction) {
            //вгору
            case 0 -> row -= steps;
            //вниз
            case 1 -> row += steps;
            //вправо
            case 2 -> column += steps;
            //вліво
            case 3 -> column -= steps;
            //вверх-вправо
            case 4 -> {
                row -= steps;
                column += steps;
            }
            //вниз-вправо
            case 5 -> {
                row += steps;
                column += steps;
            }
            //вверх-вліво
            case 6 -> {
                row -= steps;
                column -= steps;
            }
            //вниз-вліво
            case 7 -> {
                row += steps;
                column -= steps;
            }
        }

        return new int[]{row, column};
    }

    //Перевіряємо можливість розміщення (межі острова та ліміт даного виду в клітинці)
    private boolean isValidPlacing(Island island, int[] position) {
        int row = position[0];
        int column = position[1];
        int maxCount = this.getMaxCount();
        return island.isValidCell(row, column)
                && island.getCountOfOrganismTypeOnCell(row, column, this) < maxCount;
    }


    //Перевіряємо можливість розмноження
    private boolean isValidReproduce(Animal firstAnimal, Animal secondAnimal) {
        return firstAnimal.getClass().equals(secondAnimal.getClass())
                && !firstAnimal.isHasReproduced()
                && !secondAnimal.isHasReproduced()
                && ((firstAnimal.gender.equals(Gender.MALE)
                && secondAnimal.gender.equals(Gender.FEMALE))
                || firstAnimal.gender.equals(Gender.FEMALE)
                && secondAnimal.gender.equals(Gender.MALE));
    }

    private void performMove(Island island, int[] currentPosition, int[] newPosition, Animal animal) {
        island.addOrganismToCell(newPosition[0], newPosition[1], animal);
        island.removeOrganismFromCell(currentPosition[0], currentPosition[1], animal);
    }
}
