package com.javarush.kolybaba_islandlifesimulation.entities.animal.herbivorous;

import com.javarush.kolybaba_islandlifesimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Horse extends Herbivorous{
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Horse(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 400.0, 20, 4, 60.0, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Horse createRandomHorse() {
        Gender randomGender = Gender.getRandomGender();
        return new Horse(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Horse createNewOrganism() {
        return createRandomHorse();
    }
}
