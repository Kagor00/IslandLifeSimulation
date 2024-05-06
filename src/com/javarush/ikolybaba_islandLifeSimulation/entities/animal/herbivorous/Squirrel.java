package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Squirrel extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    Squirrel(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 2, 100, 3, 0.50, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Squirrel createRandomSquirrel() {
        Gender randomGender = Gender.getRandomGender();
        return new Squirrel(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Squirrel createNewOrganism() {
        return createRandomSquirrel();
    }
}
