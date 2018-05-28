package com.wakemeintime.dffc.wakemeintime.database;

import android.database.sqlite.SQLiteDatabase;

public interface ReadBehavior<T> {

    T read(int id, SQLiteDatabase db);
}
