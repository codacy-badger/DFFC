package com.wakemeintime.dffc.wakemeintime.database;

import java.util.List;

public interface CalendarEntryDao {
    long addOrUpdateCalendarEntry();
    CalendarEntry getCalendarEntry();
    List<CalendarEntry> getAllCalendarEntry();
    void delete();
}
