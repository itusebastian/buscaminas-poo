
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


// Interfaz que define el comportamiento común de las casillas del tablero de Buscaminas.
// Permite polimorfismo entre casillas normales y de mina.
public interface TileBehavior {
    // Indica si la casilla es una mina
    boolean isMine();
    // Indica si la casilla ya fue revelada
    boolean isRevealed();
    // Indica si la casilla está marcada con bandera
    boolean isFlagged();
    // Marca la casilla como revelada
    void reveal();
    // Alterna el estado de bandera (marcar/desmarcar)
    void toggleFlag();
    // Devuelve el valor a mostrar en consola según el estado de la casilla
    String getDisplayValue();
}
