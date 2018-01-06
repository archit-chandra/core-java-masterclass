package com.gemalto.oopsConcepts.polymorphism;

public class Jaws extends Movie {
    
    public Jaws() {
        super("Jaws");
    }
    
    @Override
    public String plot() {
        return "A shark eats a lot of people";
    }
}
