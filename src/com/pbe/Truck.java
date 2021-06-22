package com.pbe;

public class Truck extends Vehicle {

    // Variables specified by the Truck class
    protected int doors; // 3 / 4 / 5
    protected int gears; // 7 / 8 / 9 / 10
    protected int load; // cargo load in liters
    protected boolean isAutomate; // true / false (= manual shift)
    protected boolean hasAirbags; // true / false
    protected int currentGear;

    // Default constructor, without parameters
    public Truck() {
        super.owner = "PB"; // super causes the Vehicle constructor to be called, which initializes the variable
        super.registrationNumber = "020";
        super.vehicleType = "Truck";
        super.vehicleSubType = "Tanker";
        super.brand = "DAF";
        super.model = "Didak";
        super.version = "2300";
        super.hasEngine = true;
        super.wheels = 10;
        super.seats = 3;
        super.price = 80000;
        this.doors = 2; // this used here, but not needed per se
        this.gears = 10;
        this.load = 23000;
        this.isAutomate = false;
        this.hasAirbags = true;
        System.out.println("Constructor Truck() is called");
    }

    // Parameterized constructor. Also includes instance variables as inherited by the extended Vehicle class.
    // Note: example of method overloading, with Car now having 2 different constructors: one with and one without parameters/
    public Truck(String owner, String registrationNumber, String vehicleType, String vehicleSubType, String brand, String model, String version, boolean hasEngine, int wheels, int seats, int price, int currentVelocity, int currentDirection, int doors, int gears, int load, boolean isAutomate, boolean hasAirbags) {
        super(owner, registrationNumber, vehicleType, vehicleSubType, brand, model, version, hasEngine, wheels, seats, price, currentVelocity, currentDirection);
        this.doors = doors;
        this.gears = gears;
        this.load = load;
        this.isAutomate = isAutomate;
        this.hasAirbags = hasAirbags;
        System.out.println("Parameterized constructor Truck() is called");
    }

    // Method to accelerate car, based on a given rate, indicating appropriate gear changes
    public void accelerate(int rate) {
        System.out.println("Inside Truck accelerate() method");
        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity ==0) {
            stop();
            changeGear(0);
        } else if(newVelocity >0 && newVelocity <=20) {
            changeGear(1);
        } else if(newVelocity >20 && newVelocity <=40) {
            changeGear(2);
        } else if(newVelocity >40 && newVelocity <=50) {
            changeGear(3);
        } else if(newVelocity >50 && newVelocity <=60) {
            changeGear(4);
        } else if(newVelocity >60 && newVelocity <70) {
            changeGear(5);
        } else if(newVelocity >70 && newVelocity <=80) {
            changeGear(6);
        } else if(newVelocity >80 && newVelocity <=90) {
            changeGear(7);
        } else if(newVelocity >90 && newVelocity <=100) {
            changeGear(8);
        } else if(newVelocity >100 && newVelocity <=110) {
            changeGear(9);
        } else {
            changeGear(10);
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

    // Dynamic method dispatch test method
    void dynamicmethodispatch() {
        System.out.println("Inside Truck's dynamicmethodispatch() method");
    }
}