package org.example.enforcesingleton;

// Singleton with public final field

// Making a class a singleton can make it difficult to test its clients.
// A privileged client can invoke the private constructor reflectively with the aid of the AccessibleObject.setAccessible method.
// To defend against this attack, an exception will be thrown if it's asked to create a second instance.
public class ElvisPublicFinalField {
    public static final ElvisPublicFinalField INSTANCE;

    static {
        try {
            INSTANCE = new ElvisPublicFinalField();
        } catch (InstantiationException e) {
            throw new RuntimeException("Singleton instantiation failed", e);
        }
    }

    private static boolean isInstantiated = false;

    private ElvisPublicFinalField() throws InstantiationException {
        if (isInstantiated) {
            throw new InstantiationException("Singleton already instantiated");
        }
        isInstantiated = true;
    }

    public void leaveTheBuilding() {
        System.out.println("I'm Elvis.");
    }
}
