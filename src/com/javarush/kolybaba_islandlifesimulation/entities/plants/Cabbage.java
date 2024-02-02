package com.javarush.kolybaba_islandlifesimulation.entities.plants;

import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Cabbage extends Plant {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    public Cabbage() {
        super(ID_COUNTER.getAndIncrement(), 2.0);
    }

    public static Cabbage createRandomCabbage() {
        return new Cabbage();
    }

    @Override
    public Cabbage createNewOrganism() {
        return createRandomCabbage();
    }
}
