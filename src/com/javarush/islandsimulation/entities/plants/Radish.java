package com.javarush.islandsimulation.entities.plants;

import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Radish extends Plant {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    public Radish() {
        super(idCounter.getAndIncrement(), 0.3);
    }

    public static Radish creatRandomRadish() {
        return new Radish();
    }

    @Override
    public Radish createNewOrganism() {
        return createNewOrganism();
    }
}
