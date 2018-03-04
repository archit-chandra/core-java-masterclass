package com.gemalto.O13.SetsAndHashSet;

import java.util.HashSet;
import java.util.Set;

// final class can't be extended. It can't have any sub-classes
public final class HeavenlyBody {

    // final variables can't be modified => acts like CONSTANTS
    // You are always allowed to initialize a final variable. The compiler makes sure that you can do it only once.
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        //return satellites;
        return new HashSet<>(this.satellites);
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    // final method can not be overridden
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is : " + obj.getClass());
        System.out.println("this.getClass() is : " + this.getClass());

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57;
    }
}
