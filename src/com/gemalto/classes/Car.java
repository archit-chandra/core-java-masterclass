package com.gemalto.classes;

// classes = blueprint of object
// think of like a user-defined type, much more powerful than primitive data type

// object = instance of class

public class Car {
    
    // variables store state
    // methods store behavior
    
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;
    
    // if you specify constructor using the fields, its safe to add default
    // constructor.
    // when no constructor is defined, Java provides this by itself
    // can call one constructor from another constructor
    // Advised : not to call other method or setters from the constructors
    public Car() {
        this(5, 4, "high end model", "good engine", "blue");
    }

    // added the constructor using the fields
    // to initialize the object that is being created
    // called only once at the time when creating the object
    public Car(int doors, int wheels, String model, String engine, String color) {
        super();
        this.doors = doors;
        this.wheels = wheels;
        this.model = model;
        this.engine = engine;
        this.color = color;
    }
    
    public int getDoors() {
        return doors;
    }
    
    // getters & setters defined
    // Uses : can perform validations - see setModel()
    
    public void setDoors(int doors) {
        this.doors = doors;
    }
    
    public int getWheels() {
        return wheels;
    }
    
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("holden")) {
            this.model = model;
        } else {
            this.model = "unknown";
        }
        
    }
    
    public String getEngine() {
        return engine;
    }
    
    public void setEngine(String engine) {
        this.engine = engine;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
}
