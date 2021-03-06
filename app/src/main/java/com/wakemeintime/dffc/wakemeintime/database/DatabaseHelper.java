package com.wakemeintime.dffc.wakemeintime.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Florian Christof on 28.11.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseActivity";
    // Database Info
    private static final String DATABASE_NAME = "wakeMeInTimeDatabase";
    private static final int DATABASE_VERSION = 1;
    // Table Names
    private static final String TABLE_APPOINTMENT = "appointment";
    private static final String TABLE_CALENDAR = "calendar";
    private static final String TABLE_CALENDARENTRY = "calendarEntry";
    private static final String TABLE_WEATHERDATA = "weatherData";
    private static final String TABLE_TRAFFICDATA = "trafficData";
    private static final String TABLE_TRAINDATA = "trainData";
    // Appointment Table Columns
    private static final String KEY_APPOINTMENT_ID = "id";
    private static final String KEY_APPOINTMENT_DISABLED = "disabled";
    private static final String KEY_APPOINTMENT_REFRESH_TIME = "refreshTime";
    private static final String KEY_APPOINTMENT_CALENDARENTRY_ID_FK = "calendarEntryId";
    private static final String KEY_APPOINTMENT_WEATHERDATA_ID_FK = "weatherDataId";
    private static final String KEY_APPOINTMENT_TRAFFICDATA_ID_FK = "trafficDataId";
    private static final String KEY_APPOINTMENT_TRAINDATA_ID_FK = "trainDataId";
    // Calendar Table Columns
    private static final String KEY_CALENDAR_ID = "id";
    private static final String KEY_CALENDAR_NAME = "name";
    private static final String KEY_CALENDAR_DESCRIPTION = "description";
    private static final String KEY_CALENDAR_IS_ACTIVE = "isActive";
    // CalendarEntry Table Columns
    private static final String KEY_CALENDARENTRY_ID = "id";
    private static final String KEY_CALENDARENTRY_NAME = "name";
    private static final String KEY_CALENDARENTRY_DESCRIPTION = "description";
    private static final String KEY_CALENDARENTRY_TIME = "time";
    private static final String KEY_CALENDARENTRY_PLACE = "text";
    private static final String KEY_CALENDARENTRY_CALENDAR_ID_FK = "calendarId";
    // WeatherData Table Columns
    private static final String KEY_WEATHERDATA_ID = "id";
    private static final String KEY_WEATHERDATA_CONDITION = "condition";
    private static final String KEY_WEATHERDATA_TEMPERATURE = "temperature";
    private static final String KEY_WEATHERDATA_RAIN_PROBABILITY = "rainProbability";
    // TrafficData Table Columns
    private static final String KEY_TRAFFICDATA_ID = "id";
    private static final String KEY_TRAFFICDATA_TRAVELTIME = "traveltime";
    private static final String KEY_TRAFFICDATA_TRAFFIC_DENSITY = "trafficDensity";
    // TrainData Table Columns
    private static final String KEY_TRAINDATA_ID = "id";
    private static final String KEY_TRAINDATA_TRAVELTIME = "traveltime";
    private static final String KEY_TRAINDATA_CONNECTION_INFO = "connectionInfo";
    private static final String KEY_TRAINDATA_DELAY = "delay";
    private static DatabaseHelper sInstance;


    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_APPOINTMENT_TABLE = "CREATE TABLE " + TABLE_APPOINTMENT +
                "(" +
                KEY_APPOINTMENT_ID + " INTEGER PRIMARY KEY," + // Define a primary key
                KEY_APPOINTMENT_CALENDARENTRY_ID_FK + " INTEGER REFERENCES " + TABLE_CALENDARENTRY + "," + // Define a foreign key
                KEY_APPOINTMENT_WEATHERDATA_ID_FK + " INTEGER REFERENCES " + TABLE_WEATHERDATA + "," +
                KEY_APPOINTMENT_TRAFFICDATA_ID_FK + " INTEGER REFERENCES " + TABLE_TRAFFICDATA + "," +
                KEY_APPOINTMENT_TRAINDATA_ID_FK + " INTEGER REFERENCES " + TABLE_TRAINDATA + "," +
                KEY_APPOINTMENT_DISABLED + " INTEGER," +
                KEY_APPOINTMENT_REFRESH_TIME + " INTEGER" +
                ")";

        String CREATE_CALENDAR_TABLE = "CREATE TABLE " + TABLE_CALENDAR +
                "(" +
                KEY_CALENDAR_ID + " INTEGER PRIMARY KEY," +
                KEY_CALENDAR_NAME + " TEXT," +
                KEY_CALENDAR_DESCRIPTION + " TEXT," +
                KEY_CALENDAR_IS_ACTIVE + " INTEGER" +
                ")";

        String CREATE_CALENDARENTRY_TABLE = "CREATE TABLE " + TABLE_CALENDARENTRY +
                "(" +
                KEY_CALENDARENTRY_ID + " INTEGER PRIMARY KEY," +
                KEY_CALENDARENTRY_NAME + " TEXT," +
                KEY_CALENDARENTRY_DESCRIPTION + " TEXT," +
                KEY_CALENDARENTRY_TIME + " INTEGER," +
                KEY_CALENDARENTRY_PLACE + " TEXT," +
                KEY_CALENDARENTRY_CALENDAR_ID_FK + " INTEGER REFERENCES " + TABLE_CALENDAR +
                ")";
        String CREATE_WEATHERDATA_TABLE = "CREATE TABLE " + TABLE_WEATHERDATA +
                "(" +
                KEY_WEATHERDATA_ID + " INTEGER PRIMARY KEY," +
                KEY_WEATHERDATA_CONDITION + " TEXT," +
                KEY_WEATHERDATA_TEMPERATURE + " INTEGER," +
                KEY_WEATHERDATA_RAIN_PROBABILITY + " INTEGER" +
                ")";
        String CREATE_TRAFFICDATA_TABLE = "CREATE TABLE " + TABLE_TRAFFICDATA +
                "(" +
                KEY_TRAFFICDATA_ID + " INTEGER PRIMARY KEY," +
                KEY_TRAFFICDATA_TRAVELTIME + " INTEGER," +
                KEY_TRAFFICDATA_TRAFFIC_DENSITY + " TEXT" +
                ")";
        String CREATE_TRAINDATA_TABLE = "CREATE TABLE " + TABLE_TRAINDATA +
                "(" +
                KEY_TRAINDATA_ID + " INTEGER PRIMARY KEY," +
                KEY_TRAINDATA_TRAVELTIME + " INTEGER," +
                KEY_TRAINDATA_CONNECTION_INFO + " TEXT," +
                KEY_TRAINDATA_DELAY + " INTEGER" +
                ")";

        db.execSQL(CREATE_APPOINTMENT_TABLE);
        db.execSQL(CREATE_CALENDAR_TABLE);
        db.execSQL(CREATE_CALENDARENTRY_TABLE);
        db.execSQL(CREATE_WEATHERDATA_TABLE);
        db.execSQL(CREATE_TRAFFICDATA_TABLE);
        db.execSQL(CREATE_TRAINDATA_TABLE);
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPOINTMENT);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALENDAR);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALENDARENTRY);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEATHERDATA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRAFFICDATA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRAINDATA);
            onCreate(db);
        }
    }

    // Insert or update a user in the database
    // Since SQLite doesn't support "upsert" we need to fall back on an attempt to UPDATE (in case the
    // user already exists) optionally followed by an INSERT (in case the user does not already exist).
    // Unfortunately, there is a bug with the insertOnConflict method
    // (https://code.google.com/p/android/issues/detail?id=13045) so we need to fall back to the more
    // verbose option of querying for the user's primary key if we did an update.
    public long addOrUpdateCalendar(Calendar calendar) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long calendarId = -1;

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_CALENDAR_NAME, calendar.name);
            values.put(KEY_CALENDAR_DESCRIPTION, calendar.description);
            values.put(KEY_CALENDAR_IS_ACTIVE, calendar.isActive);

            // First try to update the user in case the user already exists in the database
            // This assumes calendarNames are unique
            int rows = db.update(TABLE_CALENDAR, values, KEY_CALENDAR_NAME + "= ?", new String[]{calendar.name});

            // Check if update succeeded
            if (rows == 1) {
                // Get the primary key of the calendar we just updated
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        KEY_CALENDAR_ID, TABLE_CALENDAR, KEY_CALENDAR_NAME);
                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(calendar.name)});
                try {
                    if (cursor.moveToFirst()) {
                        calendarId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                calendarId = db.insertOrThrow(TABLE_CALENDAR, null, values);
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add or update calendar");
        } finally {
            db.endTransaction();
        }
        return calendarId;
    }

    public long addOrUpdateTrafficData(TrafficData trafficData) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long trafficDataId = -1;

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_TRAFFICDATA_TRAVELTIME, trafficData.travelTime);
            values.put(KEY_TRAFFICDATA_TRAFFIC_DENSITY, trafficData.trafficDensity);

            // First try to update the user in case the user already exists in the database
            // This assumes calendarNames are unique TODO add density as argument
            int rows = db.update(TABLE_TRAFFICDATA, values, KEY_TRAFFICDATA_TRAVELTIME + "= ?", new String[]{String.valueOf(trafficData.travelTime)});

            // Check if update succeeded
            if (rows == 1) {
                // Get the primary key of the calendar we just updated TODO  add density as argument
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        KEY_TRAFFICDATA_ID, TABLE_TRAFFICDATA, KEY_TRAFFICDATA_TRAVELTIME);
                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(trafficData.travelTime)});
                try {
                    if (cursor.moveToFirst()) {
                        trafficDataId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                trafficDataId = db.insertOrThrow(TABLE_TRAFFICDATA, null, values);
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add or update trafficData");
        } finally {
            db.endTransaction();
        }
        return trafficDataId;
    }

    public long addOrUpdateCalendarEntry(CalendarEntry calendarEntry) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long calendarEntryId = -1;
        long calendarID = addOrUpdateCalendar(calendarEntry.calendarId);
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_CALENDARENTRY_NAME, calendarEntry.name);
            values.put(KEY_CALENDARENTRY_DESCRIPTION, calendarEntry.description);
            values.put(KEY_CALENDARENTRY_TIME, calendarEntry.time);
            values.put(KEY_CALENDARENTRY_PLACE, calendarEntry.place);
            values.put(KEY_CALENDARENTRY_CALENDAR_ID_FK, calendarID);

            // First try to update the user in case the user already exists in the database
            // This assumes calendarEntryNames are unique TODO assume other stuff
            int rows = db.update(TABLE_CALENDARENTRY, values, KEY_CALENDARENTRY_NAME + "= ?", new String[]{calendarEntry.name});

            // Check if update succeeded
            if (rows == 1) {
                // Get the primary key of the calendarEntry we just updated
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        KEY_CALENDARENTRY_ID, TABLE_CALENDARENTRY, KEY_CALENDARENTRY_NAME);
                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(calendarEntry.name)});
                try {
                    if (cursor.moveToFirst()) {
                        calendarEntryId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                calendarEntryId = db.insertOrThrow(TABLE_CALENDAR, null, values);
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add or update calendarEntry");
        } finally {
            db.endTransaction();
        }
        return calendarEntryId;
    }

    public long addOrUpdateAppointment(Appointment appointment) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long calendarEntryId = -1;
        long trafficDataID = addOrUpdateTrafficData(appointment.trafficDataId);
        long calendarEntryID = addOrUpdateCalendarEntry(appointment.calendarEntryId);
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_APPOINTMENT_DISABLED, appointment.disabled);
            values.put(KEY_APPOINTMENT_REFRESH_TIME, appointment.refreshTime);
            values.put(KEY_APPOINTMENT_CALENDARENTRY_ID_FK, calendarEntryID);
            values.put(KEY_APPOINTMENT_TRAFFICDATA_ID_FK, trafficDataID);

            // First try to update the user in case the user already exists in the database
            // This assumes calendarEntryNames are unique TODO assume other stuff
            int rows = db.update(TABLE_APPOINTMENT, values, KEY_APPOINTMENT_CALENDARENTRY_ID_FK + "= ?", new String[]{String.valueOf(calendarEntryID)});

            // Check if update succeeded
            if (rows == 1) {
                // Get the primary key of the calendarEntry we just updated
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        KEY_APPOINTMENT_ID, TABLE_APPOINTMENT, KEY_APPOINTMENT_CALENDARENTRY_ID_FK);
                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(calendarEntryID)});
                try {
                    if (cursor.moveToFirst()) {
                        calendarEntryId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                calendarEntryId = db.insertOrThrow(TABLE_APPOINTMENT, null, values);
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add or update Appointment");
        } finally {
            db.endTransaction();
        }
        return calendarEntryId;
    }

    public void deleteAllCalendar() {

        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {
            db.delete(TABLE_CALENDAR, null, null);

        } catch (Exception e) {
            Log.d(TAG, "Error while trying to delete calendar");
        } finally {
            db.endTransaction();
        }
    }

    public List<Calendar> getAllCalendar() {
        List<Calendar> calendars = new ArrayList<>();

        // SELECT * FROM CalendarS
        // LEFT OUTER JOIN USERS
        // ON CalendarS.KEY_Calendar_USER_ID_FK = USERS.KEY_USER_ID
        String CALENDAR_SELECT_QUERY =
                String.format("SELECT * FROM %s ",
                        TABLE_CALENDAR);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(CALENDAR_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Calendar newCalendar = new Calendar(cursor.getString(cursor.getColumnIndex(KEY_CALENDAR_NAME)), cursor.getString(cursor.getColumnIndex(KEY_CALENDAR_DESCRIPTION)), cursor.getString(cursor.getColumnIndex(KEY_CALENDAR_IS_ACTIVE)));
                    calendars.add(newCalendar);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get Calendars from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return calendars;
    }

    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        // SELECT * FROM CalendarS
        // LEFT OUTER JOIN USERS
        // ON CalendarS.KEY_Calendar_USER_ID_FK = USERS.KEY_USER_ID
        String Appointment_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        TABLE_APPOINTMENT);


        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Appointment_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    CalendarEntry newCalendarEntry = getCalendarEntry(cursor.getInt(cursor.getColumnIndex(KEY_APPOINTMENT_CALENDARENTRY_ID_FK)));
                    TrafficData newTrafficData = getTrafficData(cursor.getInt(cursor.getColumnIndex(KEY_APPOINTMENT_TRAFFICDATA_ID_FK)));
                    Appointment newAppointment = new Appointment(cursor.getInt(cursor.getColumnIndex(KEY_APPOINTMENT_DISABLED)), cursor.getInt(cursor.getColumnIndex(KEY_APPOINTMENT_REFRESH_TIME)), newCalendarEntry, newTrafficData);
                    appointments.add(newAppointment);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get Appointments from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return appointments;
    }

    private TrafficData getTrafficData(int newTrafficDataID) {
        TrafficData newTrafficData = null;
        String trafficData_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = %d",
                        TABLE_TRAFFICDATA, KEY_TRAFFICDATA_ID, newTrafficDataID);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(trafficData_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                newTrafficData = new TrafficData(cursor.getInt(cursor.getColumnIndex(KEY_TRAFFICDATA_TRAVELTIME)), cursor.getString(cursor.getColumnIndex(KEY_TRAFFICDATA_TRAFFIC_DENSITY)));
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get TrafficData from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return newTrafficData;
    }

    private CalendarEntry getCalendarEntry(int calendarEntryID) {
        CalendarEntry newCalendarEntry = null;
        String calendarEntry_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = %d",
                        TABLE_CALENDARENTRY, KEY_CALENDARENTRY_ID, calendarEntryID);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(calendarEntry_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                Calendar newCalendar = getCalendar(cursor.getInt(cursor.getColumnIndex(KEY_CALENDARENTRY_CALENDAR_ID_FK)));
                newCalendarEntry = new CalendarEntry(cursor.getString(cursor.getColumnIndex(KEY_CALENDARENTRY_NAME)), cursor.getString(cursor.getColumnIndex(KEY_CALENDARENTRY_DESCRIPTION)), cursor.getInt(cursor.getColumnIndex(KEY_CALENDARENTRY_TIME)), cursor.getString(cursor.getColumnIndex(KEY_CALENDARENTRY_PLACE)), newCalendar);
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get CalendarEntry from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return newCalendarEntry;
    }

    private Calendar getCalendar(int calendarID) {
        Calendar newCalendar =null;
        String calendar_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = %d",
                        TABLE_CALENDAR, KEY_CALENDAR_ID, calendarID);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(calendar_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                newCalendar = new Calendar(cursor.getString(cursor.getColumnIndex(KEY_CALENDAR_NAME)), cursor.getString(cursor.getColumnIndex(KEY_CALENDAR_DESCRIPTION)), cursor.getString(cursor.getColumnIndex(KEY_CALENDAR_IS_ACTIVE)));
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get Calendar from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return newCalendar;
    }


}