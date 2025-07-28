package com.itulabs.model;

/**
 * Interfaz que define el comportamiento común de las casillas del tablero de Buscaminas.
 */
public interface TileBehavior {
    boolean isMine();
    boolean isRevealed();
    boolean isFlagged();
    void reveal();
    void toggleFlag();
    String getDisplayValue();
}
