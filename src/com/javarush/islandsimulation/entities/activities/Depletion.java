package com.javarush.islandsimulation.entities.activities;

import com.javarush.islandsimulation.island.Island;

public interface Depletion {
    void deplete(Island island);
}
