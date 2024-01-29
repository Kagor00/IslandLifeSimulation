package com.javarush.islandsimulation.entities.animal;

import java.util.concurrent.ThreadLocalRandom;

public enum Gender {
    MALE,
    FEMALE;

    //рандомно вказуємо стать тварини
    public static Gender getRandomGender() {
        return (ThreadLocalRandom.current().nextInt(2) == 1) ? MALE : FEMALE;
    }
}
