
// Paquete que contiene la lógica principal y entrada del usuario
package com.itulabs.main;


import com.itulabs.model.Board;
import com.itulabs.model.BaseTile;
import com.itulabs.service.GameLogic;
import com.itulabs.ui.ConsoleRenderer;
import com.itulabs.util.BoardPersistence;

import java.util.Scanner;
import java.io.IOException;

// Clase principal que inicia y ejecuta el ciclo del juego Buscaminas en consola.
public class Main {

    public static void main(String[] args) {
        final int size = 10; // Tamaño del tablero
        final int mineCount = 20; // Número de minas
        final String saveFile = "board.sav"; // Archivo de guardado

        Board board = null; // Tablero de juego
        GameLogic gameLogic = null; // Lógica del juego
        ConsoleRenderer renderer = new ConsoleRenderer(); // Renderizador de consola
        Scanner scanner = new Scanner(System.in); // Entrada estándar

        // Menú de inicio
        while (true) {
            System.out.println("=== ¡Bienvenido a Buscaminas! ===");
            System.out.println("1. Nueva partida");
            System.out.println("2. Cargar última partida");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine().trim();
            if (opcion.equals("1")) {
                board = new Board(size);
                gameLogic = new GameLogic(board, mineCount);
                break;
            } else if (opcion.equals("2")) {
                try {
                    board = BoardPersistence.loadBoard(saveFile);
                    gameLogic = new GameLogic(board, mineCount);
                    System.out.println("Partida cargada correctamente.\n");
                    break;
                } catch (Exception e) {
                    System.out.println("No se pudo cargar la partida. Se iniciará una nueva partida.\n");
                    board = new Board(size);
                    gameLogic = new GameLogic(board, mineCount);
                    break;
                }
            } else if (opcion.equals("3")) {
                System.out.println("¡Hasta luego!");
                scanner.close();
                return;
            } else {
                System.out.println("Opción inválida. Intenta de nuevo.\n");
            }
        }

        // Instrucciones de juego
        System.out.println("Introduce coordenadas para jugar (formato: A3)");
        System.out.println("Puedes marcar y desmarcar (formato: F A3)");
        System.out.println("Escribe GUARDAR para guardar la partida en cualquier momento.");
        System.out.println("Dimensiones: " + size + "x" + size + " - Minas: " + mineCount);
        System.out.println("¡Buena suerte!\n");

        // Bucle principal del juego
        while (!gameLogic.isGameOver()) {
            renderer.render(board, false); // Muestra el tablero
            System.out.print("Introduce coordenada o 'GUARDAR': ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("GUARDAR")) {
                try {
                    BoardPersistence.saveBoard(board, saveFile); // Guarda la partida
                    System.out.println("Partida guardada exitosamente.\n");
                } catch (IOException e) {
                    System.out.println("Error al guardar la partida: " + e.getMessage());
                }
                continue;
            }
            UserInputHandler.Action action = null;
            try {
                action = UserInputHandler.askActionFromInput(input, size); // Parsea la acción
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }
            if (action.isFlag) {
                board.getTile(action.coord.getX(), action.coord.getY()).toggleFlag(); // Marca/desmarca bandera
            } else {
                BaseTile tile = board.getTile(action.coord.getX(), action.coord.getY());
                if (tile.isFlagged()) {
                    System.out.println("No puedes descubrir una celda marcada. Desmarca primero la bandera.");
                } else {
                    gameLogic.playTurn(action.coord); // Realiza jugada
                }
            }
        }

        // Juego terminado
        renderer.render(board, true); // Muestra el tablero final
        if (gameLogic.isPlayerWon()) {
            System.out.println("🎉 ¡Felicidades! Has ganado.");
        } else {
            System.out.println("💣 ¡Has perdido! Mejor suerte la próxima.");
        }

        scanner.close();
    }
}
