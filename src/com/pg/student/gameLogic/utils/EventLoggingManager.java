package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;

public class EventLoggingManager {
    private ArrayList<String> events;

    public EventLoggingManager() {
        this.events = new ArrayList<>();
    }

    public void ReportDeathAfterFightWith(String deadOrganismName, String winnerName) {
        String event = winnerName + " zabił\\a " + deadOrganismName;
        if(!events.contains(event))
            events.add(event);
    }

    public void ReportAboutNewOrganism(String name) {
        String event = "Urodził\\a się " + name;
        if(!events.contains(event))
            events.add(event);
    }

    public void ReportAboutTurtleDefence(String nameOfDefendedOrganism) {
        String event = "Żółw obronił się przed " + nameOfDefendedOrganism;
        if(!events.contains(event))
            events.add(event);
    }

    public void ReportAboutAntelopeEscape(String nameOfAggressor) {
        String event = "Antelopa uciekła przed " + nameOfAggressor;
        if(!events.contains(event))
            events.add(event);
    }

    public void ReportAboutGuaranaEffect(String nameOfEatingAnimal) {
        String event = "Guarana wzmacnia " + nameOfEatingAnimal;
        if(!events.contains(event))
            events.add(event);
    }

    public void ReportAboutSuperPowerUse() {
        events.add("Całopalenie aktywowane!");
    }

    public void ReportAboutSuperPowerEnd() {
        events.add("Całopalenie zakończone");
    }

    public void ReportAboutSuperPowerVictim(String victimName) {
        events.add("Całopalenie zabiło " + victimName);
    }

    public ArrayList<String> GetEvents() {
        ArrayList<String> eventsCopy = new ArrayList<>(events.size());
        eventsCopy.addAll(events);
        events.clear();
        return eventsCopy;
    }
}
