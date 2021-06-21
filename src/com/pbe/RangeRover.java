package com.pbe;

// Subclass of Car
public class RangeRover extends Car {

    private int roadServiceMonths;

    public RangeRover(String owner, String registrationNumber, String vehicleType, String vehicleSubType, String brand, String model, String version, boolean hasEngine, int wheels, int seats, int price, int currentVelocity, int currentDirection, int doors, int gears, boolean isAutomate, boolean hasAirbags, int roadServiceMonths) {
        super(owner, registrationNumber, vehicleType, vehicleSubType, brand, model, version, hasEngine, wheels, seats, price, currentVelocity, currentDirection, doors, gears, isAutomate, hasAirbags);
        this.roadServiceMonths = roadServiceMonths;
        System.out.println("Parameterized constructor RangeRover() is called");
    }

    public RangeRover() {
        super.owner = "PB";
        super.registrationNumber = "009";
        super.vehicleType = "Car";
        super.vehicleSubType = "SUV";
        super.brand = "Range Rover";
        super.model = "Evoque";
        super.version = "2.0 4WD";
        super.hasEngine = true;
        super.wheels = 4;
        super.seats = 4;
        super.price = 80000;
        this.doors = 5;
        this.gears = 5;
        this.isAutomate = true;
        this.hasAirbags = true;
        this.roadServiceMonths = 24;
        System.out.println("Constructor RangeRover() is called");
    }
}