package com.wakemeintime.dffc.wakemeintime.database;

public class Constants {

    public static final String TAG = "DatabaseActivity";
    // Database Info
    public static final String DATABASE_NAME = "wakeMeInTimeDatabase";
    public static final int DATABASE_VERSION = 1;
    // Table Names
    public static final String TABLE_APPOINTMENT = "appointment";
    public static final String TABLE_CALENDAR = "calendar";
    public static final String TABLE_CALENDARENTRY = "calendarEntry";
    public static final String TABLE_WEATHERDATA = "weatherData";
    public static final String TABLE_TRAFFICDATA = "trafficData";
    public static final String TABLE_TRAINDATA = "trainData";
    // Appointment Table Columns
    public static final String KEY_APPOINTMENT_ID = "id";
    public static final String KEY_APPOINTMENT_DISABLED = "disabled";
    public static final String KEY_APPOINTMENT_REFRESH_TIME = "refreshTime";
    public static final String KEY_APPOINTMENT_CALENDARENTRY_ID_FK = "calendarEntryId";
    public static final String KEY_APPOINTMENT_WEATHERDATA_ID_FK = "weatherDataId";
    public static final String KEY_APPOINTMENT_TRAFFICDATA_ID_FK = "trafficDataId";
    public static final String KEY_APPOINTMENT_TRAINDATA_ID_FK = "trainDataId";
    // Calendar Table Columns
    public static final String KEY_CALENDAR_ID = "id";
    public static final String KEY_CALENDAR_NAME = "name";
    public static final String KEY_CALENDAR_DESCRIPTION = "description";
    public static final String KEY_CALENDAR_IS_ACTIVE = "isActive";
    // CalendarEntry Table Columns
    public static final String KEY_CALENDARENTRY_ID = "id";
    public static final String KEY_CALENDARENTRY_NAME = "name";
    public static final String KEY_CALENDARENTRY_DESCRIPTION = "description";
    public static final String KEY_CALENDARENTRY_TIME = "time";
    public static final String KEY_CALENDARENTRY_PLACE = "text";
    public static final String KEY_CALENDARENTRY_CALENDAR_ID_FK = "calendarId";
    // WeatherData Table Columns
    public static final String KEY_WEATHERDATA_ID = "id";
    public static final String KEY_WEATHERDATA_CONDITION = "condition";
    public static final String KEY_WEATHERDATA_TEMPERATURE = "temperature";
    public static final String KEY_WEATHERDATA_RAIN_PROBABILITY = "rainProbability";
    // TrafficData Table Columns
    public static final String KEY_TRAFFICDATA_ID = "id";
    public static final String KEY_TRAFFICDATA_TRAVELTIME = "traveltime";
    public static final String KEY_TRAFFICDATA_TRAFFIC_DENSITY = "trafficDensity";
    // TrainData Table Columns
    public static final String KEY_TRAINDATA_ID = "id";
    public static final String KEY_TRAINDATA_TRAVELTIME = "traveltime";
    public static final String KEY_TRAINDATA_CONNECTION_INFO = "connectionInfo";
    public static final String KEY_TRAINDATA_DELAY = "delay";
}
