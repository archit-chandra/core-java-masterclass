package com.gemalto.oopsConcepts.classes;

public class Main {
    
    public static void main(String[] args) {
        // initializing by default constructor
        Car porche = new Car(); // initializing with 'new'
        
        // initializing by user-defined constructor by fields
        Car holden = new Car(5, 4, "high end model", "good engine", "black");
        
        // very bad approach
        // class fields must always be PRIVATE
        // to access create public getters & setters
        /* porche.model = "Carrera"; */
        porche.setModel("Carrera"); // Right approach
        System.out.println("Model is : " + porche.getModel());
        
        System.out.println(holden.getColor());
        
    }
    
}
