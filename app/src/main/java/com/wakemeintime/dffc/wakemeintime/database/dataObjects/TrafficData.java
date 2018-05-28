package com.wakemeintime.dffc.wakemeintime.database.dataObjects;

public class TrafficData {
    public int travelTime;
    public String trafficDensity;

    public TrafficData(int travelTime, String trafficDensity) {
        this.travelTime = travelTime;
        this.trafficDensity = trafficDensity;
    }

    public int getTravelTime() {
        return travelTime;
    }
    public int getTravelTimeHours() {
        return travelTime/60;
    }
}
