package org.example.staticfactory;

// Returning Objects of Varying State
// Returning objects based on dynamic conditions.
public abstract class Shape {
    public abstract String draw();

    public static Shape createShape(String type) {
        if ("circle".equalsIgnoreCase(type)) return new Circle();
        if ("square".equalsIgnoreCase(type)) return new Square();
        throw new IllegalArgumentException("Unknown shape type: " + type);
    }
}
