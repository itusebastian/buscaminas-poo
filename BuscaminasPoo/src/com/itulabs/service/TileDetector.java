package com.itulabs.service;

import com.itulabs.model.Board;
import com.itulabs.model.Coordinate;
import com.itulabs.model.Tile;

public class TileDetector {

    public void detectAdjacentMines(Board board) {
        int size = board.getSize();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Coordinate coord = new Coordinate(x, y);
                Tile tile = board.getTile(coord);

                if (!tile.isMine()) {
                    int count = countSurroundingMines(board, coord);
                    tile.setAdjacentMines(count);
                }
            }
        }
    }

    private int countSurroundingMines(Board board, Coordinate center) {
        int count = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // Saltar el centro

                int nx = center.getX() + dx;
                int ny = center.getY() + dy;

                Coordinate neighbor = new Coordinate(nx, ny);
                if (neighbor.isWithinBounds(board.getSize())) {
                    if (board.getTile(neighbor).isMine()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
