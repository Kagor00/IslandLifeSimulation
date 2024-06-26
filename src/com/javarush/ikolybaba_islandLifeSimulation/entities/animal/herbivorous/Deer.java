package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Deer extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);


    Deer(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 300.0, 20, 4, 50.0, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Deer createRandomDeer() {
        Gender randomGender = Gender.getRandomGender();
        return new Deer(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Deer createNewOrganism() {
        return createRandomDeer();
    }
}
