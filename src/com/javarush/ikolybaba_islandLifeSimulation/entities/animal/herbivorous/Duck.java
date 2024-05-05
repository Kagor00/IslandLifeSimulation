package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Duck extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    Duck(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 1.0, 200, 4, 0.15, gender);
    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Duck ceateRandomDuck(){
        Gender randomGender = Gender.getRandomGender();
        return new Duck(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Duck createNewOrganism() {
        return ceateRandomDuck();
    }
}
