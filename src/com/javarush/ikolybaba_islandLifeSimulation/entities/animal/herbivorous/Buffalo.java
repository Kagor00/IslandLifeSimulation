package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Buffalo extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    Buffalo(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 700.0, 10, 3, 100.0, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Buffalo createRandomBuffalo() {
        Gender randomGender = Gender.getRandomGender();
        return new Buffalo(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Buffalo createNewOrganism() {
        return createRandomBuffalo();
    }
}
