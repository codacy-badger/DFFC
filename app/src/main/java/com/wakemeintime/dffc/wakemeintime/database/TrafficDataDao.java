package com.wakemeintime.dffc.wakemeintime.database;

import java.util.List;

public interface TrafficDataDao {
    long addOrUpdateTrafficData();
    TrafficData getTrafficData();
    void delete();
}
