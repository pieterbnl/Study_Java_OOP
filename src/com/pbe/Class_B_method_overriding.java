package com.pbe;

// Class B extends Class A
public class Class_B_method_overriding extends Class_A_method_overriding {

    // Class B add it's own variable k
    int k;

    // constructor accepting 3 ints
    // saving them in i & j
    Class_B_method_overriding(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    void display() {
        System.out.println("k = " + k);

    //  to use version A display() instead:
//      super.display();
//      System.out.println("k = " + k);
    }
}