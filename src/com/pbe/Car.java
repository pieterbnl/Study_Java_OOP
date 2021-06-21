package com.pbe;

// Class car extends from class Vehicle
// Extending from another class (read: superclass), allows members (variables=data & methods=state) from that class to be inherited.
// To inherit the superclass variables, a constructor needs to be set for subclass Car that calls the constructor from superclass Vehicle.
// In the Car constructor, the keyword super is used, to inherit from Vehicle.
// In addition to inherited members from Vehicle, additional members can be added to Car, to define it's own specifics.
public class Car extends Vehicle {

    // Variables specified by the Car class
    protected int doors; // 3 / 4 / 5
    protected int gears = 5; // 5 / 6 / 7
    protected boolean isAutomate; // true / false (= manual shift)
    protected boolean hasAirbags; // true / false
    protected int currentGear;

    // Default constructor, without parameters
    // All of Car variables are given a default value
    // This way, even without providing any parameters, an instantiated object of Car will have a default configuration
    public Car() {
        super.owner = "PB";
        super.registrationNumber = "007";
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
        this.gears = 5;
        this.isAutomate = false;
        this.hasAirbags = true;
    }

    // Parameterized constructor. Also includes instance variables as inherited by the extended Vehicle class.
    public Car(String owner, String registrationNumber, String vehicleType, String vehicleSubType, String brand, String model, String version, boolean hasEngine, int wheels, int seats, int price, int currentVelocity, int currentDirection, int doors, int gears, boolean isAutomate, boolean hasAirbags) {
        super(owner, registrationNumber, vehicleType, vehicleSubType, brand, model, version, hasEngine, wheels, seats, price, currentVelocity, currentDirection);
        this.doors = doors;
        this.gears = gears;
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

    // Method to accelerate car, based on a given rate, indicating appropriate gear changes
    public void accelerate(int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity ==0) {
            stop();
            changeGear(0);
        } else if(newVelocity >0 && newVelocity <=20) {
            changeGear(1);
        } else if(newVelocity >20 && newVelocity <=40) {
            changeGear(2);
        } else if(newVelocity >40 && newVelocity <=60) {
            changeGear(3);
        } else if(newVelocity >60 && newVelocity <=90) {
            changeGear(4);
        } else {
            changeGear(5);
        }
        if(newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }

    // Method to change gears
    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): Changed to gear " + this.currentGear);
    }

    // Method to change the car velocity
    public void changeVelocity(int speed, int direction) {
        System.out.println("Car.changeVelocity() : Velocity " + speed + "km/hr in direction " + direction + " degrees.");
        super.move(speed, direction);
    }
}