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

    public ArrayList<String> GetEvents() {
        ArrayList<String> eventsCopy = new ArrayList<>(events.size());
        eventsCopy.addAll(events);
        events.clear();
        return eventsCopy;
    }
}
