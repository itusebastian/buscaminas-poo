
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


import java.io.Serializable;

// Representa una casilla que contiene una mina en el tablero de Buscaminas.
public class MineTile extends BaseTile implements TileBehavior, Serializable {
    private static final long serialVersionUID = 1L; // Versión para serialización

    // Constructor: inicializa la casilla como no revelada y sin bandera
    public MineTile() {
        this.isRevealed = false;
        this.isFlagged = false;
    }

    // Indica que esta casilla es una mina
    @Override
    public boolean isMine() { return true; }

    // Devuelve el valor a mostrar en consola según el estado de la casilla
    @Override
    public String getDisplayValue() {
        if (isFlagged) return " F "; // Si está marcada con bandera
        if (!isRevealed) return " ? "; // Si no está revelada
        return " * "; // Si está revelada, muestra la mina
    }
}
