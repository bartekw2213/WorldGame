package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;

public class WorldImageManager {
    PositionsManager positionsManager;

    public WorldImageManager(PositionsManager positionsManager) {
        this.positionsManager = positionsManager;
    }

    public ArrayList<String> GetPathsToImagesForOrganismsOnEachPosition() {
        ArrayList<Organism> organismOnEachPosition = positionsManager.FindWhoStandsOnEachPosition();
        ArrayList<String> pathsToImagesForOrganismsOnEachPosition = new ArrayList<>(organismOnEachPosition.size());

        for(Organism organism : organismOnEachPosition) {
            if(organism == null)
                pathsToImagesForOrganismsOnEachPosition.add("");
            else
                pathsToImagesForOrganismsOnEachPosition.add(organism.GetOrganismImgPath());
        }

        return pathsToImagesForOrganismsOnEachPosition;
    }
}
