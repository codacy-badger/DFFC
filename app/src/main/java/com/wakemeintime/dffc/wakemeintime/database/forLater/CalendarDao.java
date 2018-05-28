package com.wakemeintime.dffc.wakemeintime.database.forLater;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.Calendar;

import java.util.List;

public interface CalendarDao {
    long addOrUpdateCalendar();
    Calendar getCalendar();
    List<Calendar> getAllCalendar();
    void delete();
}
