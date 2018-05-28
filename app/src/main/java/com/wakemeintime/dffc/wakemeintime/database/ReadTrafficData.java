package com.wakemeintime.dffc.wakemeintime.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wakemeintime.dffc.wakemeintime.database.dataObjects.TrafficData;

import java.util.List;

public class ReadTrafficData implements ReadBehavior {

    @Override
    public TrafficData read(int newTrafficDataID, SQLiteDatabase db) {
        TrafficData newTrafficData = null;
        String trafficData_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = %d",
                        Constants.TABLE_TRAFFICDATA, Constants.KEY_TRAFFICDATA_ID, newTrafficDataID);


        try (Cursor cursor = db.rawQuery(trafficData_SELECT_QUERY, null)) {
            if (cursor.moveToFirst()) {
                newTrafficData = new TrafficData(cursor.getInt(cursor.getColumnIndex(Constants.KEY_TRAFFICDATA_TRAVELTIME)), cursor.getString(cursor.getColumnIndex(Constants.KEY_TRAFFICDATA_TRAFFIC_DENSITY)));
            }
        } catch (Exception e) {
            Log.d(Constants.TAG, "Error while trying to get TrafficData from database");
        }
        return newTrafficData;
    }

    @Override
    public List readAll(SQLiteDatabase db) {
        return null;
    }
}
