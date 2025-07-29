
// Paquete que contiene la lógica de servicio del juego
package com.itulabs.service;


import com.itulabs.model.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Gestiona la lógica principal del juego Buscaminas: turnos, reglas, victoria y derrota.
public class GameLogic {
    private final Board board; // Tablero de juego
    private boolean gameOver = false; // Indica si el juego terminó
    private boolean playerWon = false; // Indica si el jugador ganó
    private boolean firstMove = true; // Indica si es la primera jugada
    private final MineGenerator mineGenerator; // Generador de minas
    private final TileDetector tileDetector; // Detector de minas adyacentes

    private final int mineCount; // Número total de minas

    // Constructor: recibe el tablero y la cantidad de minas
    public GameLogic(Board board, int mineCount) {
        this.board = board;
        this.mineCount = mineCount;
        this.mineGenerator = new MineGenerator();
        this.tileDetector = new TileDetector();
    }

    // Ejecuta un turno del jugador en la coordenada indicada
    public void playTurn(Coordinate coord) {
        if (!board.isValid(coord) || gameOver) return; // No hace nada si la jugada es inválida o el juego terminó

        BaseTile tile = board.getTile(coord);
        if (tile.isRevealed()) {
            return; // Ya revelado, no hace nada
        }

        // Si es la primera jugada, genera minas y calcula minas adyacentes SOLO si el tablero no tiene minas
        if (firstMove) {
            firstMove = false;
            if (!boardHasMines()) {
                mineGenerator.generateMines(board, mineCount, coord); // Evita mina en la primera jugada
                tileDetector.detectAdjacentMines(board);
            }
        }

        reveal(coord); // Revela la casilla (y expande si es necesario)

        // Si es mina, pierde; si no, verifica victoria
        if (tile.isMine()) {
            gameOver = true;
            playerWon = false;
        } else if (checkVictory()) {
            gameOver = true;
            playerWon = true;
        }
    }

    // Verifica si el tablero ya tiene al menos una mina
    private boolean boardHasMines() {
        int size = board.getSize();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (board.getTile(x, y).isMine()) {
                    return true;
                }
            }
        }
        return false;
    }

    // Revela la casilla y expande recursivamente si no hay minas adyacentes
    private void reveal(Coordinate coord) {
        Queue<Coordinate> toReveal = new LinkedList<>(); // Cola de casillas por revelar
        Set<Coordinate> visited = new HashSet<>(); // Casillas ya procesadas

        toReveal.add(coord);

        while (!toReveal.isEmpty()) {
            Coordinate current = toReveal.poll();
            if (!board.isValid(current)) continue; // Ignora fuera de límites
            BaseTile tile = board.getTile(current);
            if (tile.isRevealed()) continue; // Ya revelada

            tile.reveal(); // Revela la casilla
            visited.add(current);

            // Si es casilla normal, sin minas adyacentes, expande a vecinos
            if (tile instanceof NormalTile && ((NormalTile) tile).getAdjacentMines() == 0 && !tile.isMine()) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx == 0 && dy == 0) continue; // No se expande a sí misma
                        Coordinate neighbor = new Coordinate(current.getX() + dx, current.getY() + dy);
                        if (!visited.contains(neighbor)) {
                            toReveal.add(neighbor);
                        }
                    }
                }
            }
        }
    }

    // Verifica si el jugador ha ganado (todas las casillas no mina están reveladas)
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

    // Indica si el juego terminó
    public boolean isGameOver() {
        return gameOver;
    }

    // Indica si el jugador ganó
    public boolean isPlayerWon() {
        return playerWon;
    }
}
