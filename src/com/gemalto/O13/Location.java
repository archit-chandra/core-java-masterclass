package com.gemalto.O13;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        //this.exits = exits;
        this.exits = new HashMap<>(exits);
        this.exits.put("Q", 0);
    }

    // no longer needed, now setting the exits in the constructor
//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //return exits;

        // more safer way than above
        // returns the copy of exits map
        // nothing outside of this class can change exits
        return new HashMap<>(exits);
    }
}
