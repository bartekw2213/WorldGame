package com.pg.student.gameLogic.organisms;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;
import com.pg.student.gameLogic.organisms.animals.*;
import com.pg.student.gameLogic.organisms.plants.*;

import java.util.ArrayList;
import java.util.Random;

public class OrganismsFactory {

    public OrganismsFactory() {

    }

    public void AddPlayerToOrganisms(ArrayList<Organism> allOrganisms, World world) {
        Position freePosition = world.GetPositionsManager().FindRandomFreePosition();
        allOrganisms.add(new Human(freePosition, world));
    }

    public void AddRandomPlantsToOrganisms(ArrayList<Organism> allOrganisms, int plantsNum, World world) {
        for(int i = 0; i < plantsNum; i++) {
            Position freePosition = world.GetPositionsManager().FindRandomFreePosition();
            allOrganisms.add(CreateRandomPlant(world, freePosition));
        }
    }

    public void AddRandomAnimalsToOrganisms(ArrayList<Organism> allOrganisms, int animalsNum, World world) {
        for(int i = 0; i < animalsNum; i++) {
            Position freePosition = world.GetPositionsManager().FindRandomFreePosition();
            allOrganisms.add(CreateRandomAnimal(world, freePosition));
        }
    }

    public Animal CreateRandomAnimal(World world, Position freePosition) {
        int randomNumber = (new Random()).nextInt(WorldConfig.ANIMALS_NUM);
        Animal createdAnimal = null;

        switch(randomNumber) {
            case 0: createdAnimal = new Antelope(freePosition, world); break;
            case 1: createdAnimal = new Fox(freePosition, world); break;
            case 2: createdAnimal = new Sheep(freePosition, world); break;
            case 3: createdAnimal = new Turtle(freePosition, world); break;
            case 4: createdAnimal = new Wolf(freePosition, world); break;
        }

        return createdAnimal;
    }

    public Plant CreateRandomPlant(World world, Position freePosition) {
        int randomNumber = (new Random()).nextInt(WorldConfig.PLANTS_NUM);
        Plant createdPlant = null;

        switch(randomNumber) {
            case 0: createdPlant = new Berry(freePosition, world); break;
            case 1: createdPlant = new Borsch(freePosition, world); break;
            case 2: createdPlant = new Grass(freePosition, world); break;
            case 3: createdPlant = new Guarana(freePosition, world); break;
            case 4: createdPlant = new Sonchus(freePosition, world); break;
        }

        return createdPlant;
    }
}
