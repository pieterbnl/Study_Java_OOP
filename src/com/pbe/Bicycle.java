package com.pbe;

public class Bicycle extends Vehicle {

    // Variables specified by the Bicycle class
    protected int gears = 11; // 10 / 11 / 12
    protected boolean hasElectricShifting; // true / false
    protected boolean hasFrontSuspension; // true / false
    protected boolean hasRearSuspension; // true / false
    protected int currentGear;

    // Default constructor, without parameters
    public Bicycle() {
        super.owner = "PB"; // super causes the Vehicle constructor to be called, which initializes the variable
        super.registrationNumber = "011";
        super.vehicleType = "Bike";
        super.vehicleSubType = "MTB";
        super.brand = "Cube";
        super.model = "Super HPC Elite";
        super.version = "2013";
        super.hasEngine = false;
        super.wheels = 2;
        super.seats = 1;
        super.price = 3400;
        this.gears = 22;
        this.hasElectricShifting = false;
        this.hasFrontSuspension = true;
        this.hasRearSuspension = false;
        System.out.println("Constructor Bicycle() is called");
    }

    // Parameterized constructor. Also includes instance variables as inherited by the extended Vehicle class.
    // Note: example of method overloading, with Car now having 2 different constructors: one with and one without parameters/
    public Bicycle(String owner, String registrationNumber, String vehicleType, String vehicleSubType, String brand, String model, String version, boolean hasEngine, int wheels, int seats, int price, int currentVelocity, int currentDirection, int doors, int gears, boolean hasElectricShifting, boolean hasFrontSuspension, boolean hasRearSuspension) {
        super(owner, registrationNumber, vehicleType, vehicleSubType, brand, model, version, hasEngine, wheels, seats, price, currentVelocity, currentDirection);
        this.gears = gears;
        this.hasElectricShifting = hasElectricShifting;
        this.hasFrontSuspension = hasFrontSuspension;
        this.hasRearSuspension = hasRearSuspension;
        System.out.println("Parameterized constructor Bicycle() is called");
    }


    // Method to accelerate bicycle, based on a given rate, indicating appropriate gear changes
    public void accelerate(int rate) {
        System.out.println("Inside Bicycle accelerate() method");
        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity ==0) {
            stop();
            changeGear(0);
        } else if(newVelocity >0 && newVelocity <=5) {
            changeGear(1);
        } else if(newVelocity >5 && newVelocity <=10) {
            changeGear(2);
        } else if(newVelocity >10 && newVelocity <=15) {
            changeGear(3);
        } else if(newVelocity >15 && newVelocity <=20) {
            changeGear(4);
        } else if(newVelocity >20 && newVelocity <=25) {
            changeGear(5);
        } else if(newVelocity >25 && newVelocity <=30) {
            changeGear(6);
        } else if(newVelocity >30 && newVelocity <=35) {
            changeGear(7);
        } else if(newVelocity >35 && newVelocity <=40) {
            changeGear(8);
        } else if(newVelocity >40 && newVelocity <=45) {
            changeGear(9);
        } else if(newVelocity >45 && newVelocity <=50) {
            changeGear(10);
        } else if(newVelocity >50 && newVelocity <=55) {
            changeGear(11);
        } else {
            changeGear(12);
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