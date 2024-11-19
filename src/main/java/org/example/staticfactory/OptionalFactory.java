package org.example.staticfactory;

import java.util.Optional;

// Named Methods for Clarity
// They allow meaningful method names, making the code more readable.
public class OptionalFactory {
    public static Optional<String> emptyOptional() {
        return Optional.empty();
    }
}
