package com.wakemeintime.dffc.wakemeintime.database;

public class CalendarEntry {
    public String name;
    public String description;
    public int time;
    public String place;
    public Calendar calendarId;

    public CalendarEntry(String name, String description, int time, String place, Calendar calendarId) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.place = place;
        this.calendarId = calendarId;
    }
}
