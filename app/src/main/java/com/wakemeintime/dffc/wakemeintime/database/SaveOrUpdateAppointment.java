package com.wakemeintime.dffc.wakemeintime.database;

import android.content.ContentValues;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.Appointment;

public class SaveOrUpdateAppointment implements SaveOrUpdateBehavior {

    private Appointment appointment;

    public void setAppointment(Appointment appointment){
        this.appointment=appointment;
    }

    @Override
    public long saveOrUpdate() {

        long trafficDataID = SaveOrUpdateTrafficData.addOrUpdateTrafficData(appointment.trafficDataId);
        long calendarEntryID = addOrUpdateCalendarEntry(appointment.calendarEntryId);
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_APPOINTMENT_DISABLED, appointment.disabled);
        values.put(Constants.KEY_APPOINTMENT_REFRESH_TIME, appointment.refreshTime);
        values.put(Constants.KEY_APPOINTMENT_CALENDARENTRY_ID_FK, calendarEntryID);
        values.put(Constants.KEY_APPOINTMENT_TRAFFICDATA_ID_FK, trafficDataID);

        String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                Constants.KEY_TRAFFICDATA_ID, Constants.TABLE_TRAFFICDATA, Constants.KEY_TRAFFICDATA_TRAVELTIME);

        String whereClause = Constants.KEY_APPOINTMENT_CALENDARENTRY_ID_FK + "= ?";

        String[] whereArgs =  new String[]{String.valueOf(calendarEntryID)};

        return addOrUpdate(Constants.TABLE_CALENDAR,values,whereClause, whereArgs, usersSelectQuery);
    }
}
