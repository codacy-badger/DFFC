package com.wakemeintime.dffc.wakemeintime.database;

/**
 * Created by Florian Christof on 28.11.2017.
 */

public class Calendar {
    public String name;
    public String description;
    public String isActive;

    public Calendar(String name, String description, String isActive) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }
    public boolean IsisActiveValidBoolean(){
        if(isActive =="true" || isActive=="false"){
            return true;
        }else {
            return false;
        }
    }
    //nur mit methode IsStringValidBoolean() verwenden
    public boolean StringToBool(String x){
        if(x =="true"){
            return true;
        }else{
            return false;
        }
    }
}