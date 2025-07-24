package com.itulabs.model;

public class Board {
    private final int size;
    private final Tile[][] tiles;

    public Board(int size) {
        this.size = size;
        this.tiles = new Tile[size][size];
        initialize();
    }

    private void initialize() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tiles[x][y] = new Tile();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public Tile getTile(Coordinate coord) {
        return tiles[coord.getX()][coord.getY()];
    }

    public void setTile(Coordinate coord, Tile tile) {
        tiles[coord.getX()][coord.getY()] = tile;
    }

    public boolean isValid(Coordinate coord) {
        return coord.getX() >= 0 && coord.getX() < size &&
               coord.getY() >= 0 && coord.getY() < size;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}