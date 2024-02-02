package com.javarush.kolybaba_islandlifesimulation.entities.plants;

import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Radish extends Plant {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    public Radish() {
        super(ID_COUNTER.getAndIncrement(), 0.3);
    }

    public static Radish creatRandomRadish() {
        return new Radish();
    }

    @Override
    public Radish createNewOrganism() {
        return createNewOrganism();
    }
}
