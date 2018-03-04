package com.gemalto.OO7_OO8.oopsConcepts.polymorphism;

public class IndependenceDay extends Movie {
    
    public IndependenceDay() {
        super("Independence Day");
    }
    
    @Override
    public String plot() {
        return "Alien attacks on the planet Earth";
    }
    
}
