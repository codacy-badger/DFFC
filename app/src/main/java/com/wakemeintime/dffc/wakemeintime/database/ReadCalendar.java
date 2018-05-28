package com.wakemeintime.dffc.wakemeintime.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.Calendar;

import java.util.ArrayList;
import java.util.List;

public class ReadCalendar implements ReadBehavior {

    @Override
    public Calendar read(int calendarID, SQLiteDatabase db) {
        Calendar newCalendar = null;
        String CALENDAR_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = %d",
                        Constants.TABLE_CALENDAR, Constants.KEY_CALENDAR_ID, calendarID);


        try (Cursor cursor = db.rawQuery(CALENDAR_SELECT_QUERY, null)) {
            if (cursor.moveToFirst()) {
                newCalendar = new Calendar(cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_NAME)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_DESCRIPTION)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_IS_ACTIVE)));
            }
        } catch (Exception e) {
            Log.d(Constants.TAG, "Error while trying to get Calendar from database");
        }
        return newCalendar;
    }

    @Override
    public List<Calendar> readAll(SQLiteDatabase db) {
        List<Calendar> calendars = new ArrayList<>();

        String CALENDAR_SELECT_QUERY =
                String.format("SELECT * FROM %s ", Constants.TABLE_CALENDAR);

        try (Cursor cursor = db.rawQuery(CALENDAR_SELECT_QUERY, null)) {
            if (cursor.moveToFirst()) {
                do {
                    Calendar newCalendar = new Calendar(cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_NAME)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_DESCRIPTION)), cursor.getString(cursor.getColumnIndex(Constants.KEY_CALENDAR_IS_ACTIVE)));
                    calendars.add(newCalendar);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(Constants.TAG, "Error while trying to get Calendars from database");
        }
        return calendars;
    }
}

