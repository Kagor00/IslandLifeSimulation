package com.javarush.kolybaba_islandlifesimulation.entities.animal.herbivorous;

import com.javarush.kolybaba_islandlifesimulation.entities.Organism;
import com.javarush.kolybaba_islandlifesimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Sheep extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Sheep(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 70.0, 140, 3, 15.0, gender);
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
