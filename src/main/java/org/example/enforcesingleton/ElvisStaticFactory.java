package org.example.enforcesingleton;

import javax.management.InstanceAlreadyExistsException;
import java.io.Serializable;

// Singleton with static factory

// Will also benefit from a try/catch block to defend against reflective attacks.
// This method is more clear and simpler in understanding that the class is a singleton.
public class ElvisStaticFactory implements Serializable {
    private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();
    // Use Serialization Versioning for version consistency.
    private static final long serialVersionUID = 1L;

    // Another exception example without a try/catch block.
    private ElvisStaticFactory() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Cannot instantiate single using reflection");
        }
    }

    public static ElvisStaticFactory getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("No. I'm Elvis!");
    }

    // readResolve method to preserve singleton property
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}
