package org.example.depencyinjection;

import java.util.ArrayList;
import java.util.List;

// Inappropriate use of singleton - inflexible & untestable!
public class SpellCheckerSingleton {
    // Example of unsatisfactory lexicon to end all lexicons.
    private final List<String> dictionary = new ArrayList<>();

    // Noninstantiable
    private SpellCheckerSingleton() {
        throw new AssertionError();
    }
    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }
}
