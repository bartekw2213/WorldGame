package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;
import java.util.Random;

public class PositionsManager {
    private ArrayList<Organism> organisms;
    private final int worldSize;

    public PositionsManager(ArrayList<Organism> organisms, int worldSize) {
        this.organisms = organisms;
        this.worldSize = worldSize;
    }

    public Position FindRandomFreePosition() {
        Position foundPosition;

        do {
            int randomX = (new Random()).nextInt(worldSize);
            int randomY = (new Random()).nextInt(worldSize);
            foundPosition = new Position(randomX, randomY);
        } while(FindOrganismOnThisPosition(foundPosition) != null);

        return foundPosition;
    }

    public Organism FindOrganismOnThisPosition(Position checkedPosition) {
        Organism foundOrganism = null;

        for (Organism organism : organisms)
            if (organism.GetOrganismPosition().equals(checkedPosition)) {
                foundOrganism = organism;
                break;
            }

        return foundOrganism;
    }
}
