
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


import java.io.Serializable;

// Clase base abstracta para representar una casilla del tablero de Buscaminas.
// Define el comportamiento común de todas las casillas (mina o normal) y permite polimorfismo.
public abstract class BaseTile implements TileBehavior, Serializable {
    private static final long serialVersionUID = 1L; // Versión para serialización
    protected boolean isRevealed; // Indica si la casilla ya fue descubierta
    protected boolean isFlagged;  // Indica si la casilla está marcada con bandera

    // Indica si la casilla es una mina (implementado en subclases)
    public abstract boolean isMine();
    // Devuelve el valor a mostrar en consola según el estado de la casilla
    public abstract String getDisplayValue();

    // Marca la casilla como revelada
    public void reveal() { this.isRevealed = true; }
    // Alterna el estado de bandera (marcar/desmarcar)
    public void toggleFlag() { this.isFlagged = !this.isFlagged; }
    // Indica si la casilla ya fue revelada
    public boolean isRevealed() { return isRevealed; }
    // Indica si la casilla está marcada con bandera
    public boolean isFlagged() { return isFlagged; }
}
