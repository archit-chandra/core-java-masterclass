package com.gemalto.OO7_OO8.oopsConcepts.polymorphism;

public class Jaws extends Movie {
    
    public Jaws() {
        super("Jaws");
    }
    
    @Override
    public String plot() {
        return "A shark eats a lot of people";
    }
}
