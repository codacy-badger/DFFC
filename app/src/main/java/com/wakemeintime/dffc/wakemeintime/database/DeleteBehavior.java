package com.wakemeintime.dffc.wakemeintime.database;

import android.database.sqlite.SQLiteDatabase;

public interface DeleteBehavior {

    void delete(SQLiteDatabase db, String tableName);
}
