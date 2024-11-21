package org.example.avoidfinalizerscleaners;

import java.lang.ref.Cleaner;

// An autocloseable class using a cleaner as a safety net

// Finalizers are unpredictable, often dangerous, and generally unnecessary.
// Cleaners are less dangerous than finalizers, but still unpredictable, slow, and generally unnecessary.
// Never do anything time-critical in a finalizer or cleaner.
// Never depend on a finalizer or cleaner to update persistent state.
// There is a severe performance penalty for using finalizers and cleaners.
// Finalizers have a serious security problem: they open your class up to finalizer attacks.
// Throwing an exception from a constructor should be sufficient to prevent an object from coming into existence;
// in the presence of finalizers, it is not.
// To protect nonfinal classes from finalizer attacks, write a final finalize method that does nothing.
// Still need to terminate files or threads? Just have your class implement AutoCloseable, and require
// its clients to invoke the close method.
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    @Override
    public void close() {
        cleanable.clean();
    }

    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state;

    // Our cleanable. Cleans the room when it's eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
}
