package com.itulabs.model;

/**
 * Thrown when trying to reveal a cell that is already revealed.
 */
public class CellAlreadyRevealedException extends RuntimeException {
    public CellAlreadyRevealedException() {
        super("Cell is already revealed.");
    }
    public CellAlreadyRevealedException(String message) {
        super(message);
    }
}
