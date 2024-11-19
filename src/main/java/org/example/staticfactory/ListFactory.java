package org.example.staticfactory;

import java.util.ArrayList;
import java.util.List;

// Support for Subtype Instantiation
// Static factories can return different subclasses or implementations.
public class ListFactory {
    public static List<String> newArrayList() {
        return new ArrayList<>();
    }
}
