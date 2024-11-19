package org.example.staticfactory;

import java.math.BigDecimal;

// Validation and Precondition Checking
// Adding validation during object creation.
public class BigDecimalFactory {
    public static BigDecimal fromString(String value) {
        if (!value.matches("\\d+\\.\\d+")) {
            throw new IllegalArgumentException("Invalid BigDecimal format: " + value);
        }
        return new BigDecimal(value);
    }
}
