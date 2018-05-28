package com.wakemeintime.dffc.wakemeintime.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.Calendar;

public class ReadCalendar implements ReadBehavior {

    @Override
    public Calendar read(int calendarID, SQLiteDatabase db) {
        Calendar newCalendar = null;
        String calendar_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = %d",
                        Constants.TABLE_CALENDAR, Constants.KEY_CALENDAR_ID, calendarID);

        Cursor cursor = db.rawQuery(calendar_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                newCalendar = new Calendar(cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_NAME)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_DESCRIPTION)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_IS_ACTIVE)));
            }
        } catch (Exception e) {
            Log.d(Constants.TAG, "Error while trying to get Calendar from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return newCalendar;
    }
}

