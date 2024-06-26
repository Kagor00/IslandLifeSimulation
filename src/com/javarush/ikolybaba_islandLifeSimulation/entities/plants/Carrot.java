package com.javarush.ikolybaba_islandLifeSimulation.entities.plants;

import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
public class Carrot extends Plant {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    public Carrot() {
        super(ID_COUNTER.getAndIncrement(), 0.3);
    }

    public static Carrot createRanomCarrot() {
        return new Carrot();
    }

    @Override
    public Carrot createNewOrganism() {
        return createRanomCarrot();
    }
}
