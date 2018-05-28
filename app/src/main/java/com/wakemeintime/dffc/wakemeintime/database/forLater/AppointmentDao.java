package com.wakemeintime.dffc.wakemeintime.database.forLater;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.Appointment;

public interface AppointmentDao {
    long addOrUpdateAppointment();
    Appointment getAppointmentr();
    void delete();
}
