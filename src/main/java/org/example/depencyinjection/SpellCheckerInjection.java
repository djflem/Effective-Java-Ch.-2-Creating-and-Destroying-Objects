package org.example.depencyinjection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Dependency injection provides flexibility and testability

// Static utility classes and singletons are inappropriate for classes whose behavior is parameterized by an underlying resource.
// Solution: Pass the resource into thr constructor when creating a new instance.
public class SpellCheckerInjection {
    // Example of unsatisfactory lexicon to end all lexicons.
    private final List<String> dictionary;

    public SpellCheckerInjection(List<String> dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public String checkWord(String word) {
        if (isValid(word)) {
            return "Checking if word exists in DotA player's brain: \"" + word + "\" exists!";
        } else {
            return "Checking if word exists in DotA player's brain: \"" + word + "\" does NOT exist!";
        }
    }
}
