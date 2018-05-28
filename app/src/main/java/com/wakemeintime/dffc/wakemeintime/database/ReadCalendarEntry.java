package com.wakemeintime.dffc.wakemeintime.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.Calendar;
import com.wakemeintime.dffc.wakemeintime.database.dataObjects.CalendarEntry;

import java.util.List;

public class ReadCalendarEntry implements ReadBehavior {

    @Override
    public CalendarEntry read(int calendarEntryID, SQLiteDatabase db) {
        ReadBehavior readBehavior = new ReadCalendar();
        CalendarEntry newCalendarEntry = null;
        String calendarEntry_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = %d",
                        Constants.TABLE_CALENDARENTRY, Constants.KEY_CALENDARENTRY_ID, calendarEntryID);

        try (Cursor cursor = db.rawQuery(calendarEntry_SELECT_QUERY, null)) {
            if (cursor.moveToFirst()) {
                Calendar newCalendar = (Calendar) readBehavior.read(cursor.getInt(cursor.getColumnIndex(Constants.KEY_CALENDARENTRY_CALENDAR_ID_FK)), db);

                newCalendarEntry = new CalendarEntry(cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDARENTRY_NAME)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDARENTRY_DESCRIPTION)), cursor.getInt(cursor.getColumnIndex(Constants.KEY_CALENDARENTRY_TIME)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDARENTRY_PLACE)), newCalendar);
            }
        } catch (Exception e) {
            Log.d(Constants.TAG, "Error while trying to get CalendarEntry from database");
        }
        return newCalendarEntry;
    }

    @Override
    public List readAll(SQLiteDatabase db) {
        return null;
    }
}
