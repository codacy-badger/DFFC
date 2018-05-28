package com.wakemeintime.dffc.wakemeintime.database;

import android.content.ContentValues;

public class SaveOrUpdateCalendarEntry implements SaveOrUpdateBehavior {
    @Override
    public long saveOrUpdate() {

        long calendarID = addOrUpdateCalendar(calendarEntry.calendarId);
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_CALENDARENTRY_NAME, calendarEntry.name);
        values.put(Constants.KEY_CALENDARENTRY_DESCRIPTION, calendarEntry.description);
        values.put(Constants.KEY_CALENDARENTRY_TIME, calendarEntry.time);
        values.put(Constants.KEY_CALENDARENTRY_PLACE, calendarEntry.place);
        values.put(Constants.KEY_CALENDARENTRY_CALENDAR_ID_FK, calendarID);

        String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                Constants.KEY_TRAFFICDATA_ID, Constants.TABLE_TRAFFICDATA, Constants.KEY_TRAFFICDATA_TRAVELTIME);

        String whereClause = Constants.KEY_CALENDARENTRY_NAME + "= ?";

        String[] whereArgs = new String[]{calendarEntry.name};

        return addOrUpdate(Constants.TABLE_CALENDAR,values,whereClause, whereArgs, usersSelectQuery);
    }
}
