package com.javarush.islandsimulation.entities.animal.herbivorous;

import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Caterpillar extends Herbivorous {
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Caterpillar(Gender gender) {
        super(idCounter.getAndIncrement(), 0.01, 1000, 1, 0.005, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Caterpillar createRandomCaterpillar() {
        Gender randomGender = Gender.getRandomGender();
        return new Caterpillar(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Caterpillar createNewOrganism() {
        return createRandomCaterpillar();
    }
}
