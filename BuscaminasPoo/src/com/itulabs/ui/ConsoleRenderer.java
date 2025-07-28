
// Se encarga de mostrar el tablero y su estado en la consola de texto.
package com.itulabs.ui;

import com.itulabs.model.Board;
import com.itulabs.model.BaseTile;

public class ConsoleRenderer {

    public void render(Board board) {
        render(board, false);
    }

    public void render(Board board, boolean revealAll) {
        int size = board.getSize();

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
            char rowLabel = (char) ('A' + row);
            System.out.printf("%2c |", rowLabel);
            for (int col = 0; col < size; col++) {
                BaseTile tile = board.getTile(row, col);
                if (tile.isFlagged()) {
                    System.out.print(" F ");
                } else if (revealAll) {
                    if (tile.isMine()) {
                        System.out.print(" * ");
                    } else if (tile.isRevealed()) {
                        System.out.print(tile.getDisplayValue());
                    } else {
                        System.out.print(" ? ");
                    }
                } else if (tile.isRevealed()) {
                    System.out.print(tile.getDisplayValue());
                } else {
                    System.out.print(" ? ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}
