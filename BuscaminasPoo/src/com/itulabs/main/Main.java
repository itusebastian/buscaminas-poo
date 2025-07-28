package com.itulabs.main;

import com.itulabs.model.Board;
import com.itulabs.model.BaseTile;
import com.itulabs.service.GameLogic;
import com.itulabs.ui.ConsoleRenderer;

import java.util.Scanner;


// Clase principal que inicia y ejecuta el ciclo del juego Buscaminas en consola.
public class Main {

    public static void main(String[] args) {
        final int size = 10;
        final int mineCount = 20;

        Board board = new Board(size);
        GameLogic gameLogic = new GameLogic(board, mineCount);
        ConsoleRenderer renderer = new ConsoleRenderer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ¡Bienvenido a Buscaminas! ===");
        System.out.println("Introduce coordenadas para jugar (formato: A3)");
        System.out.println("Puedes marcar y desmarcar (formato: F A3)");
        System.out.println("Dimensiones: " + size + "x" + size + " - Minas: " + mineCount);
        System.out.println("¡Buena suerte!\n");

        while (!gameLogic.isGameOver()) {
            renderer.render(board, false);
            UserInputHandler.Action action = UserInputHandler.askAction(scanner, size);
            if (action.isFlag) {
                board.getTile(action.coord.getX(), action.coord.getY()).toggleFlag();
            } else {
                BaseTile tile = board.getTile(action.coord.getX(), action.coord.getY());
                if (tile.isFlagged()) {
                    System.out.println("No puedes descubrir una celda marcada. Desmarca primero la bandera.");
                } else {
                    gameLogic.playTurn(action.coord);
                }
            }
        }

        // Juego terminado
        renderer.render(board, true);
        if (gameLogic.isPlayerWon()) {
            System.out.println("🎉 ¡Felicidades! Has ganado.");
        } else {
            System.out.println("💣 ¡Has perdido! Mejor suerte la próxima.");
        }

        scanner.close();
    }
    
}
