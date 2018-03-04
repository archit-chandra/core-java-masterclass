package com.gemalto.OO7_OO8.oopsConcepts.inheritance;

// incomplete class
public class Fish extends Animal {

    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }
    
    private void rest() {
        
    }
    
    private void moveMuscles() {
        
    }
    
    private void moveBackFin() {
        
    }
    
    private void swim(int speed) {
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }
    
    public int getGills() {
        return gills;
    }

    public void setGills(int gills) {
        this.gills = gills;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

}
