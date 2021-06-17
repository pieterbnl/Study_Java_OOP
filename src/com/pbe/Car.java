package com.pbe;

// Class car extends from class Vehicle
// Extending from another class (read: superclass), allows members (variables=data & methods=state) from that class to be inherited.
// To inherit the superclass variables, a constructor needs to be set for subclass Car that calls the constructor from superclass Vehicle.
// In the Car constructor, the keyword super is used, to inherit from Vehicle.
// In addition to inherited members from Vehicle, additional members can be added to Car, to define it's own specifics.
public class Car extends Vehicle {

    // Variables specified by the Car class
    private int doors; // 3 / 4 / 5
    private boolean isAutomate; // true / false (= manual shift)
    private boolean hasAirbags; // true / false

    // Default constructor, without parameters
    // All of Car variables are given a default value
    // This way, even without providing any parameters, an instantiated object of Car will have a default configuration
    public Car() {
        super.vehicleType = "Car";
        super.vehicleSubType = "Hatchback";
        super.brand = "Opel";
        super.model = "Corsa";
        super.version = "1.2 ECO";
        super.hasEngine = true;
        super.wheels = 4;
        super.seats = 4;
        super.price = 12000;
        this.doors = 4;
        this.isAutomate = false;
        this.hasAirbags = true;
    }

    // Parameterized constructor. Also includes instance variables as inherited by the extended Vehicle class.
    public Car(String vehicleType, String vehicleSubType, String brand, String model, String version, boolean hasEngine, int wheels, int seats, int price, int doors, boolean isAutomate, boolean hasAirbags) {
        super(vehicleType, vehicleSubType, brand, model, version, hasEngine, wheels, seats, price);
        this.doors = doors;
        this.isAutomate = isAutomate;
        this.hasAirbags = hasAirbags;
    }

    // Method to set vehicle brand
    public void setBrand(String brand) {
        super.brand = brand;
    }

    // Method to get vehicle brand
    public String getBrand() {
        // When returning a value:
        // - The type of data returned must be compatible with the return type of the method itself.
        // - The variable that receives the value that's returned must also be compatible.
        return brand;
    }

    // Method to get vehicle model
    public String getModel() {
        return model;
    }
    // Method to set vehicle model
    public void setModel(String model) {
        this.model = model;
    }

    public void carDetails() {  //details of car
        printDetails();         //calling method from parent class
        System.out.println("No. of doors: " + doors);
        System.out.println("Has airbags: " + hasAirbags);
        System.out.println("Is automate: " + isAutomate);
    }
}