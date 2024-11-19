package org.example.staticfactory;

import java.util.HashMap;
import java.util.Map;

// Control over Instance Creation
// Reusing instances with caching or singleton patterns.
public class Logger {
    private static final Map<String, Logger> loggerCache = new HashMap<>();
    private final String name;

    private Logger(String name) {
        this.name = name;
    }

    public static Logger getLogger(String name) {
        return loggerCache.computeIfAbsent(name, Logger::new);
    }

    public void log(String message) {
        System.out.println("[" + name + "] " + message);
    }
}
