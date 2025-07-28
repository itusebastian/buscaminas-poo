
// Representa el tablero de Buscaminas, gestionando las casillas y su estado.
package com.itulabs.model;

public class Board {
    private final int size;
    private final BaseTile[][] tiles;

    public Board(int size) {
        this.size = size;
        this.tiles = new BaseTile[size][size];
        initialize();
    }

    private void initialize() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tiles[x][y] = new NormalTile();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public BaseTile getTile(int x, int y) {
        return tiles[x][y];
    }

    public BaseTile getTile(Coordinate coord) {
        return tiles[coord.getX()][coord.getY()];
    }

    public void setTile(Coordinate coord, BaseTile tile) {
        tiles[coord.getX()][coord.getY()] = tile;
    }

    public boolean isValid(Coordinate coord) {
        return coord.getX() >= 0 && coord.getX() < size &&
               coord.getY() >= 0 && coord.getY() < size;
    }

    public BaseTile[][] getTiles() {
        return tiles;
    }
}