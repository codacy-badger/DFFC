package com.wakemeintime.dffc.wakemeintime.database;

import android.content.Context;

public class CalendarEntryDatabaseHelper extends DatabaseHelper {
    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     *
     * @param context
     */
    private CalendarEntryDatabaseHelper(Context context) {

        super(context);
    }

    private static CalendarEntryDatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new CalendarEntryDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }
}
