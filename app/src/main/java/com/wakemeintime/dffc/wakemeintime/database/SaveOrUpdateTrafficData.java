package com.wakemeintime.dffc.wakemeintime.database;

import android.content.ContentValues;

public class SaveOrUpdateTrafficData implements SaveOrUpdateBehavior {
    @Override
    public long saveOrUpdate() {
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_TRAFFICDATA_TRAVELTIME, trafficData.travelTime);
        values.put(Constants.KEY_TRAFFICDATA_TRAFFIC_DENSITY, trafficData.trafficDensity);

        String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                Constants.KEY_TRAFFICDATA_ID, Constants.TABLE_TRAFFICDATA, Constants.KEY_TRAFFICDATA_TRAVELTIME);

        String whereClause = Constants.KEY_TRAFFICDATA_TRAVELTIME + "= ?";

        String[] whereArgs = new String[]{String.valueOf(trafficData.travelTime)};

        return addOrUpdate(Constants.TABLE_CALENDAR,values,whereClause, whereArgs, usersSelectQuery);
    }
}
