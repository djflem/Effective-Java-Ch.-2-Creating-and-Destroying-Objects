package org.example.eliminateobsoleteobj;

import java.util.Arrays;
import java.util.EmptyStackException;

// Nulling out object references should be the exception rather than the norm.
// Whenever a class manages its own memory, the programmer should be alert for memory leaks.
// Another common source of memory leaks is caches.
// A third common source of memory leaks is listeners and other callbacks.
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // The addition of using null on pop() is the real example here to prevent memory leaks.
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    // Ensure space for at least one more element, roughly doubling the capacity
    // each time the array needs to grow.
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
