package org.example.enforcenoninstantiability;

// Noninstantiable utility class

// Attempting to enforce noninstantiability by making a class abstract does not work.
// A class CAN be made noninstantiable by including a private constructor.
// No instance required: Since the methods are static, you can call them without creating an object of UtilityClass. The class name is used as a qualifier (UtilityClass.methodName()).
// Utility Purpose: This approach is consistent with the utility class pattern, which focuses on functionality rather than instance-specific behavior.
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    // Add example static factory methods below
    public static String createDefaultMessage() {
        return "Default Message";
    }

    public static int[] createDefaultIntArray() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
