package com.gemalto.oopsConcepts.polymorphism;

public class IndependenceDay extends Movie {
    
    public IndependenceDay() {
        super("Independence Day");
    }
    
    @Override
    public String plot() {
        return "Alien attacks on the planet Earth";
    }
    
}
