
// Paquete que contiene la lógica de servicio del juego
package com.itulabs.service;


import com.itulabs.model.*;

// Calcula y asigna la cantidad de minas adyacentes a cada casilla normal del tablero.
public class TileDetector {

    // Recorre todo el tablero y asigna a cada casilla normal la cantidad de minas adyacentes
    public void detectAdjacentMines(Board board) {
        int size = board.getSize(); // Tamaño del tablero

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Coordinate coord = new Coordinate(x, y); // Coordenada actual
                BaseTile tile = board.getTile(coord); // Casilla actual
                // Solo calcula para casillas normales (no minas)
                if (!tile.isMine() && tile instanceof NormalTile) {
                    int count = countSurroundingMines(board, coord); // Cuenta minas alrededor
                    ((NormalTile) tile).setAdjacentMines(count); // Asigna el número de minas adyacentes
                }
            }
        }
    }

    // Cuenta cuántas minas hay alrededor de una coordenada dada (8 vecinos)
    private int countSurroundingMines(Board board, Coordinate center) {
        int count = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // Saltar el centro (la propia casilla)

                int nx = center.getX() + dx; // Fila vecina
                int ny = center.getY() + dy; // Columna vecina

                Coordinate neighbor = new Coordinate(nx, ny); // Coordenada vecina
                // Verifica que la coordenada vecina esté dentro del tablero
                if (neighbor.isWithinBounds(board.getSize())) {
                    // Si la casilla vecina es una mina, suma al contador
                    if (board.getTile(neighbor).isMine()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
