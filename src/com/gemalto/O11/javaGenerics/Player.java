package com.gemalto.O11.javaGenerics;

public abstract class Player {
    private String name;

    public Player(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
