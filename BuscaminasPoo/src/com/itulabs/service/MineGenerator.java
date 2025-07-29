
// Paquete que contiene la lógica de servicio del juego
package com.itulabs.service;


import com.itulabs.model.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Se encarga de colocar minas aleatoriamente en el tablero, evitando la zona segura inicial.
public class MineGenerator {
    private final Random random = new Random(); // Generador de números aleatorios

    // Coloca minas aleatoriamente en el tablero, evitando la zona segura alrededor de la primera jugada
    public void generateMines(Board board, int mineCount, Coordinate safeZoneCenter) {
        int size = board.getSize(); // Tamaño del tablero
        Set<Coordinate> safeZone = getSurroundingCoords(safeZoneCenter, size); // Zona segura (primer click y vecinos)
        Set<Coordinate> placed = new HashSet<>(); // Coordenadas donde ya hay minas

        while (placed.size() < mineCount) {
            int x = random.nextInt(size); // Fila aleatoria
            int y = random.nextInt(size); // Columna aleatoria
            Coordinate coord = new Coordinate(x, y); // Coordenada candidata

            // Solo coloca mina si no está en la zona segura ni repetida
            if (!placed.contains(coord) && !safeZone.contains(coord)) {
                // Coloca una mina reemplazando la casilla por MineTile
                board.setTile(coord, new MineTile());
                placed.add(coord);
            }
        }
    }

    // Devuelve el conjunto de coordenadas que forman la zona segura (centro y vecinos)
    private Set<Coordinate> getSurroundingCoords(Coordinate center, int size) {
        Set<Coordinate> surrounding = new HashSet<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = center.getX() + dx;
                int ny = center.getY() + dy;
                Coordinate coord = new Coordinate(nx, ny);
                if (coord.isWithinBounds(size)) {
                    surrounding.add(coord); // Agrega el centro y los 8 vecinos
                }
            }
        }
        return surrounding;
    }
}
