
// Representa una casilla normal (no mina) del tablero. Almacena la cantidad de minas adyacentes.
package com.itulabs.model;

public class NormalTile extends BaseTile {
    private int adjacentMines;

    public NormalTile() {
        this.isRevealed = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
    }

    @Override
    public boolean isMine() { return false; }

    @Override
    public String getDisplayValue() {
        if (isFlagged) return " F ";
        if (!isRevealed) return " ? ";
        return adjacentMines > 0 ? " " + adjacentMines + " " : "   ";
    }

    public int getAdjacentMines() { return adjacentMines; }
    public void setAdjacentMines(int adjacentMines) { this.adjacentMines = adjacentMines; }
}
