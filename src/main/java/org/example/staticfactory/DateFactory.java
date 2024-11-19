package org.example.staticfactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

// Encapsulation of Object Creation Logic
// Static factories can encapsulate complex logic for creating objects, hiding the details from the client.
public class DateFactory {
    public static LocalDate fromEpochMillis(long millis) {
        return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
