package com.pbe;

public class Class_B_method_overloading extends Class_A_method_overloading {

    // Class B add it's own variable k
    int k;

    // constructor accepting 3 ints
    // saving them in i & j
    Class_B_method_overloading(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    void display(String msg) {
        System.out.println(msg + k);
    }
}