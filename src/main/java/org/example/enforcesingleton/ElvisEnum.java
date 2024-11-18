package org.example.enforcesingleton;

// Enum singleton - the preferred approach

// Provides serialization for free and a guarantee against multiple instantiation.
// A single-element enum type is often the best way to implement a singleton.
// Cannot work if your singleton must extend a superlcass other than Enum.
// So concise, so nice!
public enum ElvisEnum {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("No! I'm the REAL Elvis!!!");
    }
}
