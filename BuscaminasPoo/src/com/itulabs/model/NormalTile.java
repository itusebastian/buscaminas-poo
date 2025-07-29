
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


import java.io.Serializable;

// Representa una casilla normal (no mina) del tablero. Almacena la cantidad de minas adyacentes.
public class NormalTile extends BaseTile implements TileBehavior, Serializable {
    private static final long serialVersionUID = 1L; // Versión para serialización
    private int adjacentMines; // Número de minas adyacentes a esta casilla

    // Constructor: inicializa la casilla como no revelada, sin bandera y sin minas adyacentes
    public NormalTile() {
        this.isRevealed = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
    }

    // Indica que esta casilla NO es una mina
    @Override
    public boolean isMine() { return false; }

    // Devuelve el valor a mostrar en consola según el estado de la casilla
    @Override
    public String getDisplayValue() {
        if (isFlagged) return " F "; // Si está marcada con bandera
        if (!isRevealed) return " ? "; // Si no está revelada
        return adjacentMines > 0 ? " " + adjacentMines + " " : "   "; // Si está revelada, muestra el número de minas adyacentes o vacío
    }

    // Devuelve la cantidad de minas adyacentes
    public int getAdjacentMines() { return adjacentMines; }
    // Asigna la cantidad de minas adyacentes
    public void setAdjacentMines(int adjacentMines) { this.adjacentMines = adjacentMines; }
}
