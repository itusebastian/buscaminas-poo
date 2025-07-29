
// Paquete que contiene la lógica de interfaz de usuario (UI)
package com.itulabs.ui;


import com.itulabs.model.Board;
import com.itulabs.model.BaseTile;

// Se encarga de mostrar el tablero y su estado en la consola de texto.
public class ConsoleRenderer {

    // Renderiza el tablero en consola (sin mostrar todas las minas)
    public void render(Board board) {
        render(board, false);
    }

    // Renderiza el tablero en consola
    // Si revealAll es true, muestra todas las minas (al final del juego)
    public void render(Board board, boolean revealAll) {
        int size = board.getSize(); // Tamaño del tablero

        // Encabezado de columnas (números 1 a size)
        System.out.print("    ");
        for (int col = 0; col < size; col++) {
            System.out.printf("%2d ", col + 1);
        }
        System.out.println();

        // Separador
        System.out.print("    ");
        for (int col = 0; col < size; col++) {
            System.out.print("---");
        }
        System.out.println();

        // Filas (letras A a ...)
        for (int row = 0; row < size; row++) {
            char rowLabel = (char) ('A' + row); // Letra de la fila
            System.out.printf("%2c |", rowLabel);
            for (int col = 0; col < size; col++) {
                BaseTile tile = board.getTile(row, col); // Casilla actual
                // Si está marcada con bandera
                if (tile.isFlagged()) {
                    System.out.print(" F ");
                } else if (revealAll) {
                    // Si se debe mostrar todo (fin del juego)
                    if (tile.isMine()) {
                        System.out.print(" * "); // Muestra mina
                    } else if (tile.isRevealed()) {
                        System.out.print(tile.getDisplayValue()); // Muestra valor revelado
                    } else {
                        System.out.print(" ? "); // Casilla oculta
                    }
                } else if (tile.isRevealed()) {
                    System.out.print(tile.getDisplayValue()); // Muestra valor revelado
                } else {
                    System.out.print(" ? "); // Casilla oculta
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}
