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

    // ************************************
    // Use of 'static'
    // ************************************
    // When a member is declared static, it can be accessed before any other objects of its class are created and without any reference to any object.
    // As main needs to be called before any objects exists, it's declared as static.
    // Both methods and variables can be declared static.
    // Instance variables declared static can be considered global variables.
    // When objects of a class are declared, no copy of static variables are made.
    // Methods declared as static have several restrictions:
    // - they can only directly call other static methods of their class
    // - they can only directly access static variables of their class
    // - they cannot refer to 'this' or 'super' in any way
    // Static methods and variable can be used independently of any object, outside of the class in which they are defined.
    // To access them, only the name of their class followed by the dot operator needs to be specified: classname.method().
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
        System.out.println("Initializing myCar");
        Car myCar = new Car();

        // Calling a different constructor by passing all required parameters for the constructor arguments
        System.out.println("Initializing myCar2");
        Car myCar2 = new Car(
                "PB",
                "007",
                "Car",
                "Hatchback",
                "Open",
                "1.2L",
                "ECO",
                true,
                4,
                4,
                12000,
                0,
                0,
                3,
                5,
                false,
                true
        );

        // Getting the brand of myCar
        System.out.println("The brand of myCar currently is: " + myCar.getBrand());

        // Setting a new brand for myCar
        myCar.setBrand("Ferrari");

        // Getting the brand of myCar again
        System.out.println("The brand of myCar now is: " + myCar.getBrand() + "\n");

        // Getting all details of myCar by calling the method carDetails() of class Car
        // This method in turn calls printDetails() in the Vehicle superclass
        System.out.println("myCar specifics:");
        myCar.carDetails();
        System.out.println();

        // Cloning myCar and printing it's details.
        System.out.println("Initializing myCar3");
        Car myCar3 = new Car(myCar);
        System.out.println("myCar3 specifics:");
        myCar3.carDetails();
        System.out.println();

        // Setting a new brand for myCar3 and printing it's details again
        myCar3.setBrand("Opel");
        System.out.println("myCar3 specifics, again:");
        myCar3.carDetails();
        System.out.println();


        // Creating a RangeRover object via RangeRover subclass of car
        System.out.println("Initializing rangeRover");
        RangeRover rangeRover = new RangeRover();

        // Using Car class methods on rangeRover object
        rangeRover.steer(45);
        rangeRover.accelerate(10);
        rangeRover.accelerate(20);
        rangeRover.accelerate(20);
        rangeRover.accelerate(20);
        rangeRover.accelerate(40);
        rangeRover.accelerate(-42);
        System.out.println();


        // *********************
        // METHOD OVERRIDING & OVERLOADING
        // *********************
        // The following is not related to the vehicle/car example
        // A method in a subclass is said to override the method in its superclass when a method in both the super- and subclass have the same name and type signature.
        // When calling an overridden method from within its subclass, it will always refer to the version of that method defined by the subclass.
        // Hiding the version of the method defined by the superclass.
        // Method overriding occurs only when the names and the type signatures of two methods are identical.
        // If they are not, they are simply overloaded (i.e. compiler will use method that matches the given arguments).

        // Method overriding test
        System.out.println("Method overriding test");
        Class_B_method_overriding class_B_obj1 = new Class_B_method_overriding(1, 2, 3);

        // calling display() in Class_B, which overrides the version in Class_A
        // to access display( in Class_A, super should be used in Class_B display()
        class_B_obj1.display();
        System.out.println();

        // Method overloading test
        System.out.println("Method overloading test");
        Class_B_method_overloading class_B_obj2 = new Class_B_method_overloading(1, 2, 3);

        // The following calls display() with different type signatures
        class_B_obj2.display("k = "); // this calls show in Class_B_method_overloading(), which takes a String as parameter
        class_B_obj2.display(); // this calls show in Class_A_method_overloading(), which takes no parameters
        System.out.println();

        // Prevent method being overridden
        // Methods declared as 'final' cannot be overwritten
        // Final is to be specified as a modifier at the start of the method declaration
        // For example "void display()" would become "final void display()"
        // When trying to override this method now, it will result in a compile-time error

        // Prevent a class from being inherited
        // Also here, precede the class declaration with final
        // Declaring a class as final implicitly declares all of its methods as final too
        // Note that a class cannot be declared both abstract and final
        // This is because an abstract class is incomplete by itself and relies upon its subclasses to provide implementations

        // *********************
        // DYNAMIC METHOD DISPATCH
        // *********************
        // Method overriding forms the basis for one of Java's most powerful concepts: dynamic method dispatch.
        // Dynamic method dispatch is the mechanism in which a call to an overridden method is resolved at run time instead of compile time.
        // This is an important concept which is how Java implements run-time polymorphism.

        // Java allows a superclass reference variable to refer to a subclass object, to resolve calls to overridden methods at run time.
        // When a superclass reference is used to call an overridden method, Java determines which version of the method to execute..
        // ..based on the type of the object being referred to at the time call.
        // I.e.: it's the type of object being referred to that determines which version of an overridden method will be executed.

        // When a superclass contains a method that is overridden by a subclass and different types of objects are referred to through a superclass reference variable..
        // .. different versions of the method are executed.
        // I.e. it's possible to define one consistent interface that is used by several different, yet related, types of objects.

        // Note: it's only possible to override methods, not the variables(data members), so runtime polymorphism cannot be achieved by data members.

        System.out.println("Dynamic method dispatch example");
        // Creating objects
        Vehicle a = new Vehicle();
        Car b = new Car();
        Truck c = new Truck();

        Vehicle r; // obtain reference of Vehicle (=superclass)
        r = a; // r refers to a Vehicle object
        r.dynamicmethodispatch(); // call's Vehicle's dynamicmethodispatch() method

        r = b; // r refers to a Car object =(subclass of Vehicle)
        r.dynamicmethodispatch(); // call's Car's dynamicmethodispatch() method, overriding Vehicle's dynamicmethodispatch() method

        r = c; // r refers to a Truck object =(subclass of Vehicle)
        r.dynamicmethodispatch(); // call's Car's dynamicmethodispatch() method, overriding Vehicle's dynamicmethodispatch() method
    }
}