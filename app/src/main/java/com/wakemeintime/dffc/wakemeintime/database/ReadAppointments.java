package com.wakemeintime.dffc.wakemeintime.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.Appointment;
import com.wakemeintime.dffc.wakemeintime.database.dataObjects.CalendarEntry;
import com.wakemeintime.dffc.wakemeintime.database.dataObjects.TrafficData;

import java.util.ArrayList;
import java.util.List;

public class ReadAppointments implements ReadBehavior {

    @Override
    public List<Appointment> read(int notNecessary, SQLiteDatabase db) {
        List<Appointment> appointments = new ArrayList<>();
        ReadBehavior readCalendarEntry = new ReadCalendarEntry();
        ReadBehavior readTrafficData = new ReadTrafficData();

        String Appointment_SELECT_QUERY = String.format("SELECT * FROM %s", Constants.TABLE_APPOINTMENT);

        try (Cursor cursor = db.rawQuery(Appointment_SELECT_QUERY, null)) {
            if (cursor.moveToFirst()) {
                do {
                    CalendarEntry newCalendarEntry = (CalendarEntry) readCalendarEntry.read(cursor.getInt(cursor.getColumnIndex(Constants.KEY_APPOINTMENT_CALENDARENTRY_ID_FK)), db);
                    TrafficData newTrafficData = (TrafficData) readTrafficData.read(cursor.getInt(cursor.getColumnIndex(Constants.KEY_APPOINTMENT_TRAFFICDATA_ID_FK)), db);
                    Appointment newAppointment = new Appointment(cursor.getInt(cursor.getColumnIndex(Constants.KEY_APPOINTMENT_DISABLED)), cursor.getInt(cursor.getColumnIndex(Constants.KEY_APPOINTMENT_REFRESH_TIME)), newCalendarEntry, newTrafficData);
                    appointments.add(newAppointment);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(Constants.TAG, "Error while trying to get Appointments from database");
        }
        return appointments;
    }

    @Override
    public List readAll(SQLiteDatabase db) {
        return null;
    }
}
