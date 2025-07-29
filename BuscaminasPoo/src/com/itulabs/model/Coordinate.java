
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


import java.io.Serializable;
import java.util.Objects;

// Representa una coordenada (posición) en el tablero de Buscaminas.
// Permite comparar posiciones y verificar límites.
public class Coordinate implements Serializable {
    private static final long serialVersionUID = 1L; // Versión para serialización
    private final int x; // Fila
    private final int y; // Columna

    // Crea una coordenada con fila x y columna y
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Devuelve la fila
    public int getX() {
        return x;
    }

    // Devuelve la columna
    public int getY() {
        return y;
    }

    // Verifica si la coordenada está dentro de los límites del tablero
    public boolean isWithinBounds(int size) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }

    // Compara si dos coordenadas son iguales (misma posición)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
        return this.x == other.x && this.y == other.y;
    }

    // Genera un hash único para la coordenada (necesario para usar en HashSet)
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
