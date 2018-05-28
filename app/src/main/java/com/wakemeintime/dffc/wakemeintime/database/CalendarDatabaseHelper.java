package com.wakemeintime.dffc.wakemeintime.database;

import android.content.Context;

public class CalendarDatabaseHelper extends DatabaseHelper {
    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     *
     * @param context
     */
    private CalendarDatabaseHelper(Context context) {
        super(context);
    }

    private static CalendarDatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new CalendarDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }
}
