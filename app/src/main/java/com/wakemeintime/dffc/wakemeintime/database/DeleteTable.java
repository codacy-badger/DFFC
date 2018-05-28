package com.wakemeintime.dffc.wakemeintime.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DeleteTable implements DeleteBehavior {

    @Override
    public void delete(SQLiteDatabase db, String tableName) {
        db.beginTransaction();
        try {
            db.delete(tableName, null, null);

        } catch (Exception e) {
            Log.d(Constants.TAG, "Error while trying to delete calendar");
        } finally {
            db.endTransaction();
        }
    }
}
