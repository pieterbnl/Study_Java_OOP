package com.pbe;

/** Study on Java Object Oriented Programming
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// CLASSES
// *********************
// Classes are used to define the shape and nature of objects, forming the basis of OOP in Java.
// A class essentially defines a new data type, which once created, can be used to instantiate objects of that type.
// The class can be considered the blueprint for an object, which becomes an instance of that class. I.e. 'object' and 'instance' are used similar.

// Classes typically consist of both code and data. An object has a state and behavior, provided by data and code respectively.
// The code -instance variables, contained within methods, and both considered 'members' of the class- defines the interface to the data.
// I.e. it's the methods that determine how the class data can be used.
// The variables in the class are called instance variables because each 'instance' of an object contains it own copy of variables.

// A class is declared by use of the class keyword. Only one class is specified as starting point for the program (containing the main() method).

// Note: Java not only dynamically allocates objects, it also automatically destroys and releases their memory (= deallocation) when no longer used.
// This process is referred to as 'garbage collection'. When no references to an object exist anymore, the object is assumed no longer to be needed.

public class Main {

    public static void main(String[] args) {

        // ************************************
        // Creating an object
        // ************************************
        // A class defines a new type of data. In below example, a bicycle as an object of type Bicycle is created.
        // The phrase 'Bicycle myBicycle' just declares a reference to object Bicycle'.
        // The new keyword allocates (read: creates) the actual object, named myBicycle.

        // All class objects in Java must be allocated by new.
        // The new operator dynamically allocates (=at run time) memory for the object and returns a reference to it.
        // myBicycle now holds the memory address of the actual Bicycle object and as such refers to 'an instance of Bicycle'.

        // new Bicycle() also specifies the constructor for the class.
        // A constructor is automatically called for when creating an object of a class.
        // If no  constructor is specified, Java will automatically run a default constructor.

        // Calling default constructor, without passing any parameters
        Car myCar = new Car();

        // Calling a different constructor by passing all required parameters for the constructor arguments
        Car myCar2 = new Car("car",
                "hatchback",
                "Opel",
                "Corsa",
                "1.2L",
                true,
                4,
                4,
                12000,
                3,
                false,
                true);

        // Getting the brand of myCar
        System.out.println("The brand of myCar currently is: " + myCar.getBrand());

        // Setting a new brand for myCar
        myCar.setBrand("Ferrari");

        // Getting the brand of myCar again
        System.out.println("The brand of myCar now is: " + myCar.getBrand() + "\n");

        // Getting all details of myCar by calling the method carDetails() of class Car
        // This method in turn calls printDetails() in the Vehicle superclass
        myCar.carDetails();
        System.out.println();
    }
}