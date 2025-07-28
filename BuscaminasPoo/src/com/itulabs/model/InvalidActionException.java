package com.itulabs.model;

/**
 * Thrown when an invalid action is attempted in the game.
 */
public class InvalidActionException extends RuntimeException {
    public InvalidActionException() {
        super("Invalid action.");
    }
    public InvalidActionException(String message) {
        super(message);
    }
}
