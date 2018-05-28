package com.wakemeintime.dffc.wakemeintime.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public interface ReadBehavior<T> {

    T read(int id, SQLiteDatabase db);
    List<T> readAll(SQLiteDatabase db);
}
