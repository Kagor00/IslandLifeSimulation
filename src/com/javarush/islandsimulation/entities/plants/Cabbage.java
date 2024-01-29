package com.javarush.islandsimulation.entities.plants;

import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Cabbage extends Plant {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    public Cabbage() {
        super(idCounter.getAndIncrement(), 2.0);
    }

    public static Cabbage createRandomCabbage() {
        return new Cabbage();
    }

    @Override
    public Cabbage createNewOrganism() {
        return createRandomCabbage();
    }
}
