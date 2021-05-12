package com.pg.student.gameLogic.organisms;

import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.PositionsManager;
import com.pg.student.gameLogic.utils.WorldConfig;
import com.pg.student.gameLogic.organisms.animals.*;
import com.pg.student.gameLogic.organisms.plants.*;

import java.util.ArrayList;
import java.util.Random;

public class OrganismsFactory {

    public OrganismsFactory() {

    }

    public void AddPlayerToOrganisms(ArrayList<Organism> allOrganisms, PositionsManager positionsManager) {
        Position freePosition = positionsManager.FindRandomFreePosition();
        allOrganisms.add(new Human(freePosition));
    }

    public void AddRandomPlantsToOrganisms(ArrayList<Organism> allOrganisms, int plantsNum, PositionsManager positionsManager) {
        for(int i = 0; i < plantsNum; i++) {
            Position freePosition = positionsManager.FindRandomFreePosition();
            allOrganisms.add(CreateRandomPlant(allOrganisms, freePosition));
        }
    }

    public void AddRandomAnimalsToOrganisms(ArrayList<Organism> allOrganisms, int animalsNum, PositionsManager positionsManager) {
        for(int i = 0; i < animalsNum; i++) {
            Position freePosition = positionsManager.FindRandomFreePosition();
            allOrganisms.add(CreateRandomAnimal(allOrganisms, freePosition));
        }
    }

    public Animal CreateRandomAnimal(ArrayList<Organism> allOrganisms, Position freePosition) {
        int randomNumber = (new Random()).nextInt(WorldConfig.ANIMALS_NUM);
        Animal createdAnimal = null;

        switch(randomNumber) {
            case 0: createdAnimal = new Antelope(freePosition); break;
            case 1: createdAnimal = new Fox(freePosition); break;
            case 2: createdAnimal = new Sheep(freePosition); break;
            case 3: createdAnimal = new Turtle(freePosition); break;
            case 4: createdAnimal = new Wolf(freePosition); break;
        }

        return createdAnimal;
    }

    public Plant CreateRandomPlant(ArrayList<Organism> allOrganisms, Position freePosition) {
        int randomNumber = (new Random()).nextInt(WorldConfig.PLANTS_NUM);
        Plant createdPlant = null;

        switch(randomNumber) {
            case 0: createdPlant = new Berry(freePosition); break;
            case 1: createdPlant = new Borsch(freePosition); break;
            case 2: createdPlant = new Grass(freePosition); break;
            case 3: createdPlant = new Guarana(freePosition); break;
            case 4: createdPlant = new Sonchus(freePosition); break;
        }

        return createdPlant;
    }
}
