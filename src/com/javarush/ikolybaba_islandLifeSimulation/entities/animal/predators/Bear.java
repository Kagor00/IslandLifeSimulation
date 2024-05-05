package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.predators;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Bear extends Predator {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Bear(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 500.0, 5, 2, 80.0, gender);
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
