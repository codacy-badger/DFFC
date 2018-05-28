package com.wakemeintime.dffc.wakemeintime.database;

import android.content.ContentValues;

public class SaveOrUpdateCalendar implements SaveOrUpdateBehavior {
    @Override
    public long saveOrUpdate() {

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_CALENDAR_NAME, calendar.name);
        values.put(Constants.KEY_CALENDAR_DESCRIPTION, calendar.description);
        values.put(Constants.KEY_CALENDAR_IS_ACTIVE, calendar.isActive);

        String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                Constants.KEY_CALENDAR_ID, Constants.TABLE_CALENDAR, Constants.KEY_CALENDAR_NAME);

        String whereClause = Constants.KEY_CALENDAR_NAME + "= ?";

        String[] whereArgs = new String[]{calendar.name};

        return addOrUpdate(Constants.TABLE_CALENDAR,values,whereClause, whereArgs, usersSelectQuery);
    }
}
