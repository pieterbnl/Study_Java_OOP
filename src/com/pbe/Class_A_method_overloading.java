package com.pbe;

public class Class_A_method_overloading {

    int i, j;

    // constructor accepting 2 ints and saving them in i & j
    Class_A_method_overloading(int a, int b) {
        i = a;
        j = b;
    }

    // displaying variable i & j
    void display() {
        System.out.println("i = " + i + " and j = " + j);
    }
}