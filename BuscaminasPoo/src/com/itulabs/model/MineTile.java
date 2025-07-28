
// Representa una casilla que contiene una mina en el tablero de Buscaminas.
package com.itulabs.model;

public class MineTile extends BaseTile implements TileBehavior {
    public MineTile() {
        this.isRevealed = false;
        this.isFlagged = false;
    }

    @Override
    public boolean isMine() { return true; }

    @Override
    public String getDisplayValue() {
        if (isFlagged) return " F ";
        if (!isRevealed) return " ? ";
        return " * ";
    }
}
