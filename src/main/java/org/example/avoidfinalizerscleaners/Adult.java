package org.example.avoidfinalizerscleaners;

// Room's cleaner is used only as a safety net. If clients surrounded all Room instantiations in
// try-with-resources blocks, automatic cleaning will never be required.
public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("Welp. Take it easy.");
        }
    }
}
