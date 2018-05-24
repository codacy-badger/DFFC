package com.wakemeintime.dffc.wakemeintime.database;

import java.util.List;

public interface AppointmentDao {
    long addOrUpdateAppointment();
    Appointment getAppointmentr();
    void delete();
}
