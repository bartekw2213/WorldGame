package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;
import java.util.Random;

public class PositionsManager {
    private final ArrayList<Organism> organisms;
    private final int worldSize;
    private final int possiblePositionsAroundOnePoint = 8;
    private final int[][] offsetsAroundOnePoint = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

    public PositionsManager(ArrayList<Organism> organisms, int worldSize) {
        this.organisms = organisms;
        this.worldSize = worldSize;
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

    public ArrayList<Organism> FindWhoStandsOnEachPosition() {
        ArrayList<Organism> returnedArray = new ArrayList<>(worldSize * worldSize);

        for(int i = 0; i < worldSize; i++) {
            for(int j = 0; j < worldSize; j++)
                returnedArray.add(FindOrganismOnThisPosition(new Position(i, j)));
        }

        return returnedArray;
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

    public Position FindRandomPositionAroundThisPosition(Position position) {
        int randomX, randomY;

        do {
            randomX = position.GetX() + (new Random()).nextInt(3) - 1;
            randomY = position.GetY() + (new Random()).nextInt(3) - 1;
        } while(IsThisPositionOutOfBounds(new Position(randomX, randomY)));

        return new Position(randomX, randomY);
    }

    public Position FindFreePositionAroundThisPosition(Position position) {
        Position freePosition = null;

        for(int i = 0; i < possiblePositionsAroundOnePoint; i++) {
            Position possiblePosition = new Position(position.GetX() + offsetsAroundOnePoint[i][0],
                    position.GetY() + offsetsAroundOnePoint[i][1]);

            if(!IsThisPositionOutOfBounds(possiblePosition) && FindOrganismOnThisPosition(possiblePosition) == null) {
                freePosition = possiblePosition;
                break;
            }
        }

        return freePosition;
    }

    private boolean IsThisPositionOutOfBounds(Position position) {
        return position.GetX() < 0 || position.GetY() < 0 || position.GetX() >= worldSize || position.GetY() >= worldSize;
    }
}
