package com.javarush.islandsimulation.entities.animal.herbivorous;

import com.javarush.islandsimulation.entities.Organism;
import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Sheep extends Herbivorous {
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Sheep(Gender gender) {
        super(idCounter.getAndIncrement(), 70.0, 140, 3, 15.0, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Sheep createRandomSheep() {
        Gender randomGender = Gender.getRandomGender();
        return new Sheep(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Organism createNewOrganism() {
        return createRandomSheep();
    }
}
