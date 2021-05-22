package com.pg.student.gameLogic.organisms;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;
import com.pg.student.gameLogic.organisms.animals.*;
import com.pg.student.gameLogic.organisms.plants.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class OrganismsFactory implements Serializable {
    private final ArrayList<Organism> allOrganisms;
    private final World world;
    //@TODO przeniesc funkcje z tworzace organizmy z organismsManager
    public OrganismsFactory(ArrayList<Organism> allOrganisms, World world) {
        this.allOrganisms = allOrganisms;
        this.world = world;
    }

    public void AddNewOrganismSelectedByUser(String organismName, int x, int y) {
        Position position = new Position(x, y);

        switch(organismName) {
            case WorldConfig.ANTELOPE_NAME: allOrganisms.add(new Antelope(position, world)); break;
            case WorldConfig.BERRY_NAME: allOrganisms.add(new Berry(position, world)); break;
            case WorldConfig.BORSCH_NAME: allOrganisms.add(new Borsch(position, world)); break;
            case WorldConfig.FOX_NAME: allOrganisms.add(new Fox(position, world)); break;
            case WorldConfig.GRASS_NAME: allOrganisms.add(new Grass(position, world)); break;
            case WorldConfig.GUARANA_NAME: allOrganisms.add(new Guarana(position, world)); break;
            case WorldConfig.SHEEP_NAME: allOrganisms.add(new Sheep(position, world)); break;
            case WorldConfig.SONCHUS_NAME: allOrganisms.add(new Sonchus(position, world)); break;
            case WorldConfig.TURTLE_NAME: allOrganisms.add(new Turtle(position, world)); break;
            case WorldConfig.WOLF_NAME: allOrganisms.add(new Wolf(position, world)); break;
        }
    }

    public void AddPlayerToOrganisms() {
        Position freePosition = world.GetPositionsManager().FindRandomFreePosition();
        allOrganisms.add(new Human(freePosition, world));
    }

    public void AddRandomPlantsToOrganisms(int plantsNum) {
        for(int i = 0; i < plantsNum; i++) {
            Position freePosition = world.GetPositionsManager().FindRandomFreePosition();
            allOrganisms.add(CreateRandomPlant(freePosition));
        }
    }

    public void AddRandomAnimalsToOrganisms(int animalsNum) {
        for(int i = 0; i < animalsNum; i++) {
            Position freePosition = world.GetPositionsManager().FindRandomFreePosition();
            allOrganisms.add(CreateRandomAnimal(freePosition));
        }
    }

    public Animal CreateRandomAnimal(Position freePosition) {
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

    public Plant CreateRandomPlant(Position freePosition) {
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
