package com.javarush.islandsimulation.entities.animal.predators;

import com.javarush.islandsimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Eagle extends Predator{
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Eagle(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 6.0, 20, 3, 1.0, gender);
    }


    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Eagle createRandomEagle(){
        Gender randomGender = Gender.getRandomGender();
        return new Eagle(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Eagle createNewOrganism() {
        return createRandomEagle();
    }
}
