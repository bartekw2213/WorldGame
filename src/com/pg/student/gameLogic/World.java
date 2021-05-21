package com.pg.student.gameLogic;

import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.organisms.OrganismsFactory;
import com.pg.student.gameLogic.utils.*;

import java.io.Serializable;
import java.util.ArrayList;

public class World implements Serializable {
    private final int worldSize;
    private final PositionsManager positionsManager;
    private final OrganismsManager organismsManager;
    private final EventLoggingManager eventLoggingManager;
    private final WorldImageManager worldImageManager;
    private final ArrayList<Organism> allOrganisms;
    private WorldConfig.USER_MOVES userMove;

    public World(int worldSize, int initialOrganismsNum, int frameWidth) {
        this.worldSize = worldSize;
        this.allOrganisms = new ArrayList<>(this.worldSize * this.worldSize);
        this.positionsManager = new PositionsManager(allOrganisms, this.worldSize);
        this.organismsManager = new OrganismsManager(allOrganisms);
        this.worldImageManager = new WorldImageManager(positionsManager, frameWidth);
        this.eventLoggingManager = new EventLoggingManager();
        CreateOrganisms(initialOrganismsNum);
    }

    private void CreateOrganisms(int initialOrganismsNum) {
        final int plantsNum = (int)((initialOrganismsNum - 1) / (WorldConfig.INITIAL_ANIMALS_TO_PLANTS_RATIO + 1));
        final int animalsNum = initialOrganismsNum - 1 - plantsNum;
        OrganismsFactory factory = new OrganismsFactory();

        factory.AddPlayerToOrganisms(allOrganisms, this);
        factory.AddRandomPlantsToOrganisms(allOrganisms, plantsNum, this);
        factory.AddRandomAnimalsToOrganisms(allOrganisms, animalsNum, this);
    }

    public void TriggerRound() {
        organismsManager.SortOrganisms();
        organismsManager.MakeMoveForEveryOrganism();
    }

    public void SetUserMove(WorldConfig.USER_MOVES userMove) {
        this.userMove = userMove;
    }

    public int GetWorldSize() { return this.worldSize; }

    public PositionsManager GetPositionsManager() {
        return positionsManager;
    }

    public OrganismsManager GetOrganismsManager() { return organismsManager; }

    public EventLoggingManager GetEventLoggingManager() { return eventLoggingManager; }

    public WorldImageManager GetWorldImageManager() { return worldImageManager; }

    public WorldConfig.USER_MOVES GetUserMove() { return userMove; }
}
