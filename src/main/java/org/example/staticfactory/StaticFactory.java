package org.example.staticfactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class StaticFactory {
    // Static factories can be utilized in place of public constructors. They are simply
    // a static method that returns an instance of the class.
    // One advantage of static factory methods is that, unlike constructors, they have names.
    // Second advantage, they are not required to create a new object each time they're invoked.
    // Third advantage, they can return an object of any subtype of their return type.
    // Fourth advantage, the class of the returned object can vary from call to call as a function of the input parameters.
    // Fifth, the class of the returned object need not exist when the class containing the method is written.
    // The main limitation of providing only static factory methods is that classes without public or protected constructors cannot be subclassed.
    // A second shortcoming of static factory methods is that they are hard for programmers to find.

    // This method translates a boolean primitive value into a Boolean object reference.
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
