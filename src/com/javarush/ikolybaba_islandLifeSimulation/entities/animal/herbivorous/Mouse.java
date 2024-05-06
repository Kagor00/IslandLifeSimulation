package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Mouse extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    Mouse(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 0.05, 500, 1, 0.01, gender);
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
