package com.javarush.islandsimulation.entities.animal.herbivorous;

import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Mouse extends Herbivorous {
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Mouse(Gender gender) {
        super(idCounter.getAndIncrement(), 0.05, 500, 1, 0.01, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Mouse createRandomMouse() {
        Gender randomGender = Gender.getRandomGender();
        return new Mouse(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Mouse createNewOrganism() {
        return createRandomMouse();
    }
}
