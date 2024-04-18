package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.predators;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Fox extends Predator {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Fox(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 8.0, 30, 2, 2.0, gender);

    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Fox createRandomFox() {
        Gender randomGender = Gender.getRandomGender();
        return new Fox(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Fox createNewOrganism() {
        return createRandomFox();
    }
}
