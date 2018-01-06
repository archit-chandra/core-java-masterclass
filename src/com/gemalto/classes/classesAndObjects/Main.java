package com.gemalto.classes.classesAndObjects;

public class Main {

    public static void main(String[] args) {
        Car porche = new Car(); // initializing with 'new'
        Car holden = new Car();

        // very bad approach
        // class fields must always be PRIVATE
        // to access create public getters & setters
        /* porche.model = "Carrera"; */
        porche.setModel("Carrera"); // Right approach
        System.out.println("Model is : " + porche.getModel());
    }

}
