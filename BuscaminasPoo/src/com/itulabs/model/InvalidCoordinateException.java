package com.itulabs.model;

/**
 * Thrown when a coordinate is out of the valid board range.
 */
public class InvalidCoordinateException extends RuntimeException {
    public InvalidCoordinateException() {
        super("Invalid coordinate.");
    }
    public InvalidCoordinateException(String message) {
        super(message);
    }
}
