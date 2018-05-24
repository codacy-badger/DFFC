<<<<<<< HEAD
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
=======
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
>>>>>>> 5c6d409bf552fe9d6aab47052ddabcb2714180a9
