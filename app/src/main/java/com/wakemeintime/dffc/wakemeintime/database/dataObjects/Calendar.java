package com.wakemeintime.dffc.wakemeintime.database.dataObjects;

/**
 * Created by Florian Christof on 28.11.2017.
 */

public class Calendar {
    public String name;
    public String description;
    public String isActive;

    public Calendar(String name, String description, String isActive) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }
}
