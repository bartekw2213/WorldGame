package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;
import java.util.Random;

public class PositionsManager {
    private final ArrayList<Organism> organisms;
    private final int worldSize;
    private final int attemptsToFindPosition = 20;
    private final int possiblePositionsAroundOnePoint = 4;
    private final int[][] offsetsAroundOnePoint = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

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
        Position randomPosition = null;
        PositionsAroundOnePoint positionsAroundOnePoint = new PositionsAroundOnePoint(position);

        while(positionsAroundOnePoint.IsAnyPositionLeft()) {
            Position possiblePosition = positionsAroundOnePoint.GetRandomPosition();

            if(IsThisPositionWithinGameBounds(possiblePosition)) {
                randomPosition = possiblePosition;
                break;
            }
        }

        return randomPosition;
    }

    public Position FindFreePositionAroundThisPosition(Position position) {
        Position freePosition = null;
        PositionsAroundOnePoint positionsAroundOnePoint = new PositionsAroundOnePoint(position);

        while(positionsAroundOnePoint.IsAnyPositionLeft()) {
            Position possiblePosition = positionsAroundOnePoint.GetRandomPosition();

            if(IsThisPositionWithinGameBounds(possiblePosition) && FindOrganismOnThisPosition(possiblePosition) == null) {
                freePosition = possiblePosition;
                break;
            }
        }

        return freePosition;
    }

    private boolean IsThisPositionWithinGameBounds(Position position) {
        return position.GetX() >= 0 || position.GetY() >= 0 || position.GetX() < worldSize || position.GetY() < worldSize;
    }

    private class PositionsAroundOnePoint {
        private final ArrayList<Position> possiblePossitions;

        public PositionsAroundOnePoint(Position position) {
            this.possiblePossitions = new ArrayList<>(4);
            this.possiblePossitions.add(new Position(position.GetX(), position.GetY() - 1));
            this.possiblePossitions.add(new Position(position.GetX(), position.GetY() + 1));
            this.possiblePossitions.add(new Position(position.GetX() + 1, position.GetY()));
            this.possiblePossitions.add(new Position(position.GetX() - 1, position.GetY()));
        }

        public Position GetRandomPosition() {
            int randomNumber = (new Random()).nextInt(possiblePossitions.size());
            Position possiblePosition = possiblePossitions.get(randomNumber);
            int randomPositionX = possiblePosition.GetX();
            int randomPositionY = possiblePosition.GetY();

            possiblePossitions.remove(possiblePosition);
            return new Position(randomPositionX, randomPositionY);
        }

        public boolean IsAnyPositionLeft() {
            return this.possiblePossitions.size() > 0;
        }
    }
}
