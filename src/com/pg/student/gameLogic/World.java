package com.pg.student.gameLogic;

import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.organisms.OrganismsFactory;
import com.pg.student.gameLogic.utils.EventLoggingManager;
import com.pg.student.gameLogic.utils.OrganismsManager;
import com.pg.student.gameLogic.utils.PositionsManager;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.util.ArrayList;

public class World {
    private final int worldSize;
    private final PositionsManager positionsManager;
    private final OrganismsManager organismsManager;
    private final EventLoggingManager eventLoggingManager;
    private final ArrayList<Organism> allOrganisms;

    public World(int worldSize, int initialOrganismsNum) {
        this.worldSize = worldSize;
        this.allOrganisms = new ArrayList<>(this.worldSize * this.worldSize);
        this.positionsManager = new PositionsManager(allOrganisms, this.worldSize);
        this.organismsManager = new OrganismsManager(allOrganisms);
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

    public PositionsManager GetPositionsManager() {
        return positionsManager;
    }

    public OrganismsManager GetOrganismsManager() { return organismsManager; }

    public EventLoggingManager GetEventLoggingManager() { return eventLoggingManager; }
}
