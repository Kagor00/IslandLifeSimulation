package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Goat extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Goat(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 60.0, 140, 3, 10.0, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Goat createRandomGoat() {
        Gender randomGender = Gender.getRandomGender();
        return new Goat(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Goat createNewOrganism() {
        return createRandomGoat();
    }
}
