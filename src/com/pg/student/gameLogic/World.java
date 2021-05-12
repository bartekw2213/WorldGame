package com.pg.student.gameLogic;

import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.organisms.OrganismsFactory;
import com.pg.student.gameLogic.utils.PositionsManager;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.util.ArrayList;

public class World {
    private final int worldSize;
    private PositionsManager positionsManager;
    private ArrayList<Organism> allOrganisms;

    public World(int worldSize, int initialOrganismsNum) {
        this.worldSize = worldSize;
        this.positionsManager = new PositionsManager(allOrganisms, this.worldSize);
        CreateOrganisms(initialOrganismsNum);
    }

    private void CreateOrganisms(int initialOrganismsNum) {
        final int plantsNum = (int)((initialOrganismsNum - 1) / (WorldConfig.INITIAL_ANIMALS_TO_PLANTS_RATIO + 1));
        final int animalsNum = initialOrganismsNum - 1 - plantsNum;
        OrganismsFactory factory = new OrganismsFactory();
        allOrganisms.ensureCapacity(worldSize * worldSize);

        factory.AddPlayerToOrganisms(allOrganisms, positionsManager);
        factory.AddRandomPlantsToOrganisms(allOrganisms, plantsNum, positionsManager);
        factory.AddRandomAnimalsToOrganisms(allOrganisms, animalsNum, positionsManager);
    }
}
