package org.example.staticfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Improved Performance
// Using object pools or other techniques to improve performance.
public class ExecutorFactory {
    public static ExecutorService newCachedThreadPool() {
        return Executors.newCachedThreadPool();
    }
}
