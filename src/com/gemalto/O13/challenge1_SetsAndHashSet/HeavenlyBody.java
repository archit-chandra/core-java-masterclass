package com.gemalto.O13.challenge1_SetsAndHashSet;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    //    private final int bodyType;

//    private static final int STAR = 1;
//    private static final int PLANET = 2;
//    private static final int DWARF_PLANET = 3;
//    private static final int MOON = 4;
//    private static final int COMET = 5;
//    private static final int ASTEROID = 6;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID;
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    /*public String getName() {
        return name;
    }*/

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    // To restrict that only moon can be added as satellite to the planet
//    public boolean addMoon(HeavenlyBody moon) {
//        return this.satellites.add(moon);
//    }

    public boolean addSatellites(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    /*public BodyTypes getBodyType() {
        return bodyType;
    }*/

    // final because not to be overriden by sub-classes
    // to obtain symmetric equality
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // If name & bodyType are same => same object
        // Before, the check was only for name,
        // but now HeavenlyBody of different bodyType can have the same name;
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            // after Key is added
            /*if (this.name.equals(theObject.getName())) {
                return this.bodyType == theObject.getBodyType();
            }*/
            return this.key.equals(theObject.key);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        //System.out.println("hashcode called");
        //// after Key is added
        /*return this.name.hashCode() + 57 + this.bodyType.hashCode();*/
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + " : " + this.key.bodyType + " : " + this.orbitalPeriod;
    }

    public static final class Key {

        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.getBodyType() == key.bodyType);
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + " : " + this.bodyType;
        }
    }
}
