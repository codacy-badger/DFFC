package com.wakemeintime.dffc.wakemeintime.database;

import java.util.List;

public interface CalendarDao {
    long addOrUpdateCalendar();
    Calendar getCalendar();
    List<Calendar> getAllCalendar();
    void delete();
}
