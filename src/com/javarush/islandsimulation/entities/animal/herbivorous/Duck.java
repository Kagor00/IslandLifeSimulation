package com.javarush.islandsimulation.entities.animal.herbivorous;

import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Duck extends Herbivorous {
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Duck(Gender gender) {
        super(idCounter.getAndIncrement(), 1.0, 200, 4, 0.15, gender);
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
