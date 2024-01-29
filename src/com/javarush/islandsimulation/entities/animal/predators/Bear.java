package com.javarush.islandsimulation.entities.animal.predators;

import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Bear extends Predator {
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Bear(Gender gender) {
        super(idCounter.getAndIncrement(), 500.0, 5, 2, 80.0, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Bear createRandomBear() {
        Gender randomGender = Gender.getRandomGender();
        return new Bear(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Bear createNewOrganism() {
        return createRandomBear();
    }
}
