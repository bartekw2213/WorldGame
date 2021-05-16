package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;

public class EventLoggingManager {
    private ArrayList<String> events;

    public EventLoggingManager() {
        this.events = new ArrayList<>();
    }

    public void ReportDeathAfterFightWith(String deadOrganismName, String winnerName) {
        events.add(winnerName + " zabił\\a " + deadOrganismName);
    }

    public void ReportAboutNewOrganism(String name) {
        events.add("Urodził\\a się " + name);
    }

    public ArrayList<String> GetEvents() {
        ArrayList<String> eventsCopy = new ArrayList<>(events.size());
        eventsCopy.addAll(events);
        events.clear();
        return eventsCopy;
    }
}
