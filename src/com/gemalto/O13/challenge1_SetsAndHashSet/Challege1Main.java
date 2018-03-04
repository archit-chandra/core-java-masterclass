package com.gemalto.O13.challenge1_SetsAndHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Challege1Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon); // temp is Earth

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Demios", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon); // temp is Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon); // temp is Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon); // temp is Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon); // temp is Jupiter

        tempMoon = new Moon("Genymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon); // temp is Jupiter

        tempMoon = new Moon("Castillo", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon); // temp is Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("--------Planets----------");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey());
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("-------Moons of " + body.getKey() + "---------");
        for (HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        // since no duplicates allowed in Sets, we can do below
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("--------All moons in the solar system---------");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }

        // Pluto save again, but as a Dwarf Planet, it can't be saved as Planet because Set won't allow duplication
        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        solarSystem.put(pluto.getKey(), pluto);
        planets.add(pluto);

        // Pluto shown twice, once as Planet and other as dwarf planet
        System.out.println("--------Planets Again With Extra Pluto----------");
        for (HeavenlyBody planet : planets) {
            System.out.println(planet);
            //System.out.println("\t" + planet.geKey() + " : " + planet.getOrbitalPeriod());
        }

        System.out.println();
        System.out.println("--------Symmetric equality----------");
        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(pluto));
        System.out.println(pluto.equals(earth1));

        System.out.println("-------------Pluto check in Solar System------------------");
        // If extra Pluto changed from DWARF_PLANET to PLANET, output:
        // Pluto : PLANET : 842.0
        // null
        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));


        System.out.println();
        System.out.println("--------The Solar System contains:----------");
        for (HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println(heavenlyBody);
        }


    }
}
