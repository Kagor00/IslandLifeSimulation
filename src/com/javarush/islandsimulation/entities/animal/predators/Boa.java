package com.javarush.islandsimulation.entities.animal.predators;

import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Boa extends Predator {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Boa(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 15.0, 30, 1, 3.0, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Boa createRandomBoa() {
        Gender randomGender = Gender.getRandomGender();
        return new Boa(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Boa createNewOrganism() {
       return createRandomBoa();
    }
}
