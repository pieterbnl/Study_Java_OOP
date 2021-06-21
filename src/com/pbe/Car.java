package com.pbe;
// *********************
// INHERITANCE
// *********************
// Inheritance allows the creations of hierarchical classifications.In this example class car extends from class Vehicle.
// Extending from a class (read: superclass), with use of the extends keyword, members (variables=data & methods=state) from that class are inherited.

// The class that's been extended, the subclass, is a specialized version of the superclass.
// It inherits all of the members defined by the superclass and can add it's own specific elements.

// Having subclasses that add unique attributes compared to their superclass, is the essence of inheritance.
// The superclass is a completely independent, stand-alone class that can be used on it's own.
// The subclass can be a super class for another subclass.
// A subclass can have only one superclass. But a superclass can have multiple subclasses.

// Although a subclass includes all members of the superclass, it cannot access the superclass members that have been declared private.
// Members that have been declared private, remain private to their class, not accessible by any code outside its class, including subclasses.

// In a class hierarchy, constructors complete in order of derivation, from superclass to subclass.
// And since super() must be the first statement executed in a subclass constructor, this order is the same with or without use of super().
// If super() is not used, the default or parameterless constructor of each superclass is executed.
// It make sense that constructors are executed in order of derivation because a superclass has no knowledge of any subclass.
// Run Main() to see examples of order in which the constructors are called during compilation.

public class Car extends Vehicle {

    // *********
    // Methods access control
    // *********
    // Java access modifiers are public, private and protected (which only applies when inheritance is involved)
    // Public: a member of a public class can be accessed by any other code
    // Private: a member of a private class can only be accessed by other members of its class
    // When no access modifier is used, by default the member of a class is public within its own package and cannot be accessed outside of its package
    // Usually, its better to restrict access to the data members of a class and only allow access via methods (i.e. public getters & setters methods)

    // To inherit the superclass variables, a constructor needs to be set for subclass Car that calls the constructor from superclass Vehicle.
    // When a subclass needs to refer to its superclass, it can do so with use of the keyword super.
    // The keyword super has 2 general forms:
    // 1. Used to call the superclass' constructor
    // 2. Used to access a member of the superclass that has been hidden by a member of a subclass.

    // As for 1., the constructor executed will be the one that matches the arguments.
    // Note that super must always be the first statement executed inside a subclass constructor!
    // In below Car's constructor, the keyword super is used to call it's superclass Vehicle constructor.
    // In addition to inherited members from Vehicle, additional members are added to Car (indicated by the this keyword), to define it's own specifics.
    // All of Car variables are given a default value.
    // This way, even without providing any parameters, an instantiated object of Car will have a default configuration.

    // As for 2, the second use for super is applicable when member names of a subclass hide members by the same name of its superclass.
    // For example a variable i is defined in both the super- and subclass. To differentiate to which version of i is referred:
    // - super.i can be used to refer to the superclass variable i
    // - i or this.i can be used to refer to the (current) subclass variable i
    // I.e. super allows access to the variable i defined in the superclass which is hidden by the subclass variable i.

    // Variables specified by the Car class
    protected int doors; // 3 / 4 / 5
    protected int gears = 5; // 5 / 6 / 7
    protected boolean isAutomate; // true / false (= manual shift)
    protected boolean hasAirbags; // true / false
    protected int currentGear;

    // Default constructor, without parameters
    public Car() {
        super.owner = "PB"; // super causes the Vehicle constructor to be called, which initializes the variable
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
        this.doors = 4; // this used here, but not needed per se
        this.gears = 5;
        this.isAutomate = false;
        this.hasAirbags = true;
        System.out.println("Constructor Car() is called");
    }

    // Parameterized constructor. Also includes instance variables as inherited by the extended Vehicle class.
    // Note: example of method overloading, with Car now having 2 different constructors: one with and one without parameters/
    public Car(String owner, String registrationNumber, String vehicleType, String vehicleSubType, String brand, String model, String version, boolean hasEngine, int wheels, int seats, int price, int currentVelocity, int currentDirection, int doors, int gears, boolean isAutomate, boolean hasAirbags) {
        super(owner, registrationNumber, vehicleType, vehicleSubType, brand, model, version, hasEngine, wheels, seats, price, currentVelocity, currentDirection);
        this.doors = doors;
        this.gears = gears;
        this.isAutomate = isAutomate;
        this.hasAirbags = hasAirbags;
        System.out.println("Parameterized constructor Car() is called");
    }

    // Example of constructor taking an object as parameters, allowing a new object to be created the same as an existing object
    // When an object reference is passed to a method, the reference itself is passed by use of call-by-value.
    // Because the value that's being passed refers to an object, the copy of that value still refers to the same object as its corresponding argument does.
    public Car(Car car) {
        super.owner = car.owner;
        super.registrationNumber = car.registrationNumber;
        super.vehicleType = car.vehicleType;
        super.vehicleSubType = car.vehicleSubType;
        super.brand = car.brand;
        super.model = car.model;
        super.version = car.version;
        super.hasEngine = car.hasEngine;
        super.wheels = car.wheels;
        super.seats = car.seats;
        super.price = car.price;
        this.doors = car.doors;
        this.gears = car.gears;
        this.isAutomate = car.isAutomate;
        this.hasAirbags = car.hasAirbags;
        System.out.println("Constructor Car() with Car object is called");
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