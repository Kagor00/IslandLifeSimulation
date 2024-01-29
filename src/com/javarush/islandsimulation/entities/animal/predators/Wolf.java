package com.javarush.islandsimulation.entities.animal.predators;


import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Wolf extends Predator {
    private static final AtomicInteger idCounter = new AtomicInteger(0);


    public Wolf(Gender gender) {
        super(idCounter.getAndIncrement(), 50.0, 30, 3, 8.0, gender);

    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Wolf createRandomWolf() {
        Gender randomGender = Gender.getRandomGender();
        return new Wolf(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Wolf createNewOrganism() {
       return createRandomWolf();
    }
}
