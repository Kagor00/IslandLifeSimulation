package com.javarush.ikolybaba_islandLifeSimulation.entities.animal.herbivorous;

import com.javarush.ikolybaba_islandLifeSimulation.entities.animal.Gender;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Rabbit extends Herbivorous {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Rabbit(Gender gender) {
        super(ID_COUNTER.getAndIncrement(), 2.0, 150, 2, 0.45, gender);

    }

    /* Статичний метод для заповнення популяції,
     використовується для швидкого заповнення популяції виду на острові при ініціалізації */
    public static Rabbit createRandomRabbit() {
        Gender randomGender = Gender.getRandomGender();
        return new Rabbit(randomGender);
    }

    /* Створення організмів,
    використовується в тих методах, які приймають організми певного виду
    і повертають нові організми того ж виду */
    @Override
    public Rabbit createNewOrganism() {
        return createRandomRabbit();
    }
}
