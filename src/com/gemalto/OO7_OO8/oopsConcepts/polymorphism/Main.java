package com.gemalto.OO7_OO8.oopsConcepts.polymorphism;

public class Main {
    
    public static void main(String[] args) {
        for (int val = 1; val < 11; val++) {
            Movie movie = randomMovie();
            System.out.println("Movie #" + val + " : " + movie.getName()); // obtains different movie name from
                                                                           // super-class
            System.out.println("Movie Plot : " + movie.plot()); // obtains different movie plot from sub-class
            // Polymorphism movie.plot()
        }
    }
    
    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated : " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
            default:
                return null;
        }
    }
    
}
