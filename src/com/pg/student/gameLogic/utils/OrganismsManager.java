package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;

public class OrganismsManager {
    private ArrayList<Organism> organisms;
    private ArrayList<Organism> newBornOrganismsInRound;
    private ArrayList<Organism> deadOrganismsInRound;

    public OrganismsManager(ArrayList<Organism> organisms) {
        this.organisms = organisms;
        this.newBornOrganismsInRound = new ArrayList<>();
        this.deadOrganismsInRound = new ArrayList<>();
    }

    public void KillOrganism(Organism organism) {
        deadOrganismsInRound.add(organism);
    }

    public void AddOrganism(Organism organism) {
        newBornOrganismsInRound.add(organism);
    }

    public void SortOrganisms() {
        organisms.sort((organism1, organism2) -> {
            if(organism1.GetInitiative() == organism2.GetInitiative())
                return Integer.compare(organism2.GetAge(), organism1.GetAge());
            return Integer.compare(organism2.GetInitiative(), organism1.GetInitiative());
        });
    }

    public void MakeMoveForEveryOrganism() {
        for(Organism organism : organisms)
            organism.Action();
        AddNewBornOrganismsToGame();
        RemoveDeadOrganismsFromGame();
    }

    private void AddNewBornOrganismsToGame() {
        organisms.addAll(newBornOrganismsInRound);
        newBornOrganismsInRound.clear();
    }

    private void RemoveDeadOrganismsFromGame() {
        organisms.removeAll(deadOrganismsInRound);
        deadOrganismsInRound.clear();
    }
}
