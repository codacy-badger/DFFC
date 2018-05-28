package com.wakemeintime.dffc.wakemeintime.database.forLater;

import java.util.List;

public interface TrafficDataDao {
    long addOrUpdateTrafficData();
    TrafficData getTrafficData();
    void delete();
}
