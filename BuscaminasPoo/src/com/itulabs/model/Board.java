
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


import java.io.Serializable;

// Representa el tablero de Buscaminas, gestionando las casillas y su estado.
// Se encarga de almacenar y manipular todas las casillas (minas y normales).
public class Board implements Serializable { // Implementa Serializable para permitir guardar/cargar el tablero
    private static final long serialVersionUID = 1L; // Versión para serialización
    private final int size; // Tamaño del tablero (número de filas/columnas)
    private final BaseTile[][] tiles; // Matriz de casillas (mina o normal)

    // Crea un tablero vacío del tamaño indicado y lo inicializa con casillas normales
    public Board(int size) {
        this.size = size;
        this.tiles = new BaseTile[size][size];
        initialize();
    }

    // Inicializa todas las posiciones del tablero con casillas normales (sin minas)
    private void initialize() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tiles[x][y] = new NormalTile(); // Cada casilla es normal al inicio
            }
        }
    }

    // Devuelve el tamaño del tablero
    public int getSize() {
        return size;
    }

    // Devuelve la casilla en la posición (x, y)
    public BaseTile getTile(int x, int y) {
        return tiles[x][y];
    }

    // Devuelve la casilla en la coordenada dada
    public BaseTile getTile(Coordinate coord) {
        return tiles[coord.getX()][coord.getY()];
    }

    // Asigna una casilla (mina o normal) en la coordenada dada
    public void setTile(Coordinate coord, BaseTile tile) {
        tiles[coord.getX()][coord.getY()] = tile;
    }

    // Verifica si una coordenada está dentro de los límites del tablero
    public boolean isValid(Coordinate coord) {
        return coord.getX() >= 0 && coord.getX() < size &&
               coord.getY() >= 0 && coord.getY() < size;
    }

    // Devuelve la matriz completa de casillas (para renderizado o guardado)
    public BaseTile[][] getTiles() {
        return tiles;
    }
}