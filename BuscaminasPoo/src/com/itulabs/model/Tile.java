package com.itulabs.model;

public class Tile {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int adjacentMines;

    public Tile() {
        this.isMine = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        this.isMine = mine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void toggleFlag() {
        this.isFlagged = !this.isFlagged;
    }

    public void reveal() {
        this.isRevealed = true;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public String getDisplayValue() {
        if (isFlagged) {
            return " F ";
        } else if (!isRevealed) {
            return " ? ";
        } else if (isMine) {
            return " * ";
        } else if (adjacentMines > 0) {
            return " " + adjacentMines + " ";
        } else {
            return "   ";
        }
    }
}
