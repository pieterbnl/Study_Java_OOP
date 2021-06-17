package com.pbe;

public class Vehicle {

    // Variables specified by the Vehicle class
    protected String vehicleType; // "bike", "car", "boat"
    protected String vehicleSubType; // sedan, coupe, hatchback, station, suv, cabriolet
    protected String brand;
    protected String model;
    protected String version;
    protected boolean hasEngine;
    protected int wheels;
    protected int seats;
    protected int price;

    // ************************************
    // Constructors, this keyword and instance variable hiding
    // ************************************
    // A constructor is automatically called when an object of the class is created and is used to automatically initialize the class variables
    // By initializing the internal state of an object, the code that creates the instance, immediately has a fully initialized, usable object.

    // A constructor has the same name as the class in which it resides (Vehicle) and is written in similar fashion as a method.
    // They have however, no return type (not even void) because the implicit return type of the constructor of a class, is the class type itself.
    // This is why 'class-var = new classname();' has () after the classname. This is the constructor being called.

    // When no constructor is explicitly defined for a class, and only then, Java creates a default constructor for that class.
    // With the default constructor, all non-initialized variables will have their default values:
    // zero for numeric types, null for reference types and false for booleans.

    // Constructor, without parameters
    // Note that the Vehicle's instance variables are all given a pre-set value
    // This way, even if an instance of Vehicle is instantiated without passing any arguments, all instance variables will be set with a default value
    public Vehicle() {
        this.vehicleType = "car";
        this.vehicleSubType = "Hatchback";
        this.brand = "Ford";
        this.model = "Fiesta";
        this.version = "1.2L";
        this.hasEngine = true;
        this.wheels = 4;
        this.seats = 4;
        this.price = 15000;
    }

    // Constructor with parameters: a parameterized constructor
    // To have this constructor executed, Vehicle() must be called with passing parameters for each of the defined arguments
    // The constructor will then initialize the as specified with the parameters
    // As can be seen, it's possible to have local variables such as these method parameters, overlapping with the instance variables names of the class.
    // As a result the local variables 'hide' the instance variables. To differentiate between the both, the this keyword can be used.
    // The This keyword can be used inside any method to refer to the current object; it is always a reference to the object on which the method was invoked.
    // This way any namespace collisions which may occur between the local- and instance variables, are resolved.
    //
    public Vehicle(String vehicleType, String vehicleSubType, String brand, String model, String version, boolean hasEngine, int wheels, int seats, int price) {
        this.vehicleType = vehicleType;
        this.vehicleSubType = vehicleSubType;
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.hasEngine = hasEngine;
        this.wheels = wheels;
        this.seats = seats;
        this.price = price;
    }

    // *********
    // Methods
    // *********
    // Classes usually consist of instance variables and methods. Methods define the behavior of a class.
    // It is possible to create a class that only contains data and no methods, but rare.
    // Methods are typically used to access the (encapsulated) class instance variables. I.e.: they define the interface to the class.
    // Methods can also be added for the purpose to be used by the class itself.

    // Methods are to be given a type and name, and it's possible to provide parameters: 'type name(parameters)'.. followed by the method body between {}

    // The type can be any valid type (String, boolean, int, etc.), including (own created) class types.
    // If a method does not return a value, it's return type must be 'void'.
    // Methods with a type have to return a value to the calling routine with use of a the return statement: 'return value', with value being the value returned.

    // The name of a method can be any legal identifier, as long as it's not yet used within the current scope.

    // Parameters are variables that receive the value of the arguments passed to the method when called for.
    // If the method has no arguments, the () after the method name is left empty

    // Method to print the details of Vehicle
    public void printDetails() {
        System.out.println("Type of vehicle: " + vehicleType);
        System.out.println("Sub type of vehicle: " + vehicleSubType);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Version: " + version);
        System.out.println("Has engine: " + hasEngine);
        System.out.println("No. of wheels: " + wheels);
        System.out.println("No. of seats: " + seats);
        System.out.println("Price: " + price);
    }
}
