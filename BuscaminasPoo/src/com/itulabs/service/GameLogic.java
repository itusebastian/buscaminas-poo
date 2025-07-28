
// Gestiona la lógica principal del juego Buscaminas: turnos, reglas, victoria y derrota.
package com.itulabs.service;

import com.itulabs.model.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GameLogic {
    private final Board board;
    private boolean gameOver = false;
    private boolean playerWon = false;
    private boolean firstMove = true;
    private final MineGenerator mineGenerator;
    private final TileDetector tileDetector;

    private final int mineCount;

    public GameLogic(Board board, int mineCount) {
        this.board = board;
        this.mineCount = mineCount;
        this.mineGenerator = new MineGenerator();
        this.tileDetector = new TileDetector();
    }

    public void playTurn(Coordinate coord) {
        if (!board.isValid(coord) || gameOver) return;

        BaseTile tile = board.getTile(coord);
        if (tile.isRevealed()) {
            return; // ya revelado
        }

        if (firstMove) {
            firstMove = false;
            mineGenerator.generateMines(board, mineCount, coord);
            tileDetector.detectAdjacentMines(board);
        }

        reveal(coord);

        if (tile.isMine()) {
            gameOver = true;
            playerWon = false;
        } else if (checkVictory()) {
            gameOver = true;
            playerWon = true;
        }
    }

    private void reveal(Coordinate coord) {
        Queue<Coordinate> toReveal = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();

        toReveal.add(coord);

        while (!toReveal.isEmpty()) {
            Coordinate current = toReveal.poll();
            if (!board.isValid(current)) continue;
            BaseTile tile = board.getTile(current);
            if (tile.isRevealed()) continue;

            tile.reveal();
            visited.add(current);

            if (tile instanceof NormalTile && ((NormalTile) tile).getAdjacentMines() == 0 && !tile.isMine()) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx == 0 && dy == 0) continue;
                        Coordinate neighbor = new Coordinate(current.getX() + dx, current.getY() + dy);
                        if (!visited.contains(neighbor)) {
                            toReveal.add(neighbor);
                        }
                    }
                }
            }
        }
    }

    private boolean checkVictory() {
        int size = board.getSize();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                BaseTile tile = board.getTile(x, y);
                if (!tile.isRevealed() && !tile.isMine()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }
}
