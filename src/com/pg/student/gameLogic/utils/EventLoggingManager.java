package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.organisms.Organism;

import java.util.ArrayList;

public class EventLoggingManager {
    private ArrayList<String> events;

    public EventLoggingManager() {
        this.events = new ArrayList<>();
    }

    public void ReportDeathAfterFightWith(Organism deadOrganism, Organism winner) {

    }

    public void ReportAboutNewOrganism(String organismName) {

    }
}
