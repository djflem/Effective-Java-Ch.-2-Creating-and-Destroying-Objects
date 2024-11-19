package org.example.staticfactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Immutable Object Creation
// Ensuring immutability through static factories.
public class ImmutableListFactory {
    public static List<String> immutableList(String... elements) {
        return Collections.unmodifiableList(Arrays.asList(elements));
    }
}
