package com.javarush.islandsimulation.entities.plants;


import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Grass extends Plant {
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Grass() {
        super(idCounter.getAndIncrement(), 0.1);
    }

    public static Grass createRandomGrass() {
        return new Grass();
    }

    @Override
    public Grass createNewOrganism() {
        return createRandomGrass();
    }
}
