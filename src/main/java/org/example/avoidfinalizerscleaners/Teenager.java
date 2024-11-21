package org.example.avoidfinalizerscleaners;

// Never prints "Cleaning Room". An example of the unpredictability of using Cleaners.
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        //System.gc(); // An attempt to force Cleaner to work. Still not a guarantee!
        System.out.println("Aight Imma head out.");
    }
}
