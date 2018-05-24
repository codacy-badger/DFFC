package com.wakemeintime.dffc.wakemeintime.database;

public class Appointment {
    public boolean disabled;
    public int refreshTime;
    public CalendarEntry calendarEntryId;
    public TrafficData trafficDataId;

    public Appointment(int disabled, int refreshTime, CalendarEntry calendarEntryId, TrafficData trafficDataId) {
        if(disabled==1){
            this.disabled = true;
        }else{
            this.disabled = false;
        }
        this.refreshTime = refreshTime;
        this.calendarEntryId = calendarEntryId;
        this.trafficDataId = trafficDataId;
    }
}
