package com.itulabs.service;

import com.itulabs.model.Board;
import com.itulabs.model.Coordinate;
import com.itulabs.model.Tile;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MineGenerator {
    private final Random random = new Random();

    public void generateMines(Board board, int mineCount, Coordinate safeZoneCenter) {
        int size = board.getSize();
        Set<Coordinate> safeZone = getSurroundingCoords(safeZoneCenter, size);
        Set<Coordinate> placed = new HashSet<>();

        while (placed.size() < mineCount) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            Coordinate coord = new Coordinate(x, y);

            if (!placed.contains(coord) && !safeZone.contains(coord)) {
                Tile tile = board.getTile(coord);
                tile.setMine(true);
                placed.add(coord);
            }
        }
    }

    private Set<Coordinate> getSurroundingCoords(Coordinate center, int size) {
        Set<Coordinate> surrounding = new HashSet<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = center.getX() + dx;
                int ny = center.getY() + dy;
                Coordinate coord = new Coordinate(nx, ny);
                if (coord.isWithinBounds(size)) {
                    surrounding.add(coord);
                }
            }
        }
        return surrounding;
    }
}
