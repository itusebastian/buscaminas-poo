
// Clase base abstracta para representar una casilla del tablero de Buscaminas.
// Define el comportamiento común de todas las casillas (mina o normal) y permite polimorfismo.
package com.itulabs.model;

public abstract class BaseTile implements TileBehavior {
    protected boolean isRevealed;
    protected boolean isFlagged;

    public abstract boolean isMine();
    public abstract String getDisplayValue();

    public void reveal() { this.isRevealed = true; }
    public void toggleFlag() { this.isFlagged = !this.isFlagged; }
    public boolean isRevealed() { return isRevealed; }
    public boolean isFlagged() { return isFlagged; }
}
