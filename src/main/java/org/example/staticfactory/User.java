package org.example.staticfactory;

// Avoiding Constructor Overload Ambiguity
// Using named factory methods instead of overloaded constructors.
public class User {
    private final String email;
    private final int id;

    private User(String email) {
        this.email = email;
        this.id = -1;
    }

    private User(int id) {
        this.email = null;
        this.id = id;
    }

    public static User fromEmail(String email) {
        return new User(email);
    }

    public static User fromId(int id) {
        return new User(id);
    }

    public String getDescription() {
        return email != null ? "User with email: " + email : "User with ID: " + id;
    }
}
