package org.example.depencyinjection;

import java.util.ArrayList;
import java.util.List;

// Inappropriate use of static utility - inflexible & untestable!
public class SpellCheckerStaticUtility {
    // Example of unsatisfactory lexicon to end all lexicons.
    private static final List<String> dictionary = new ArrayList<>();

    // Noninstantiable
    private SpellCheckerStaticUtility() {
        throw new AssertionError();
    }

    public static boolean isValid(String word) {
        return dictionary.contains(word);
    }
}
