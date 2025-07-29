
// Paquete que contiene la lógica principal y entrada del usuario
package com.itulabs.main;


import com.itulabs.model.Coordinate;
import java.util.Scanner;
import java.util.InputMismatchException;

// Gestiona la entrada del usuario desde consola y traduce las acciones a coordenadas y tipo de acción (marcar o descubrir).
public class UserInputHandler {
    // Representa una acción del usuario: marcar/desmarcar o descubrir una casilla.
    public static class Action {
        public final boolean isFlag; // true si es acción de marcar/desmarcar
        public final Coordinate coord; // Coordenada de la acción
        public Action(boolean isFlag, Coordinate coord) {
            this.isFlag = isFlag;
            this.coord = coord;
        }
    }

    // Solicita al usuario una acción por consola y la traduce a objeto Action
    public static Action askAction(Scanner scanner, int size) {
        while (true) {
            System.out.print("Introduce coordenada (ejemplo: A3) : ");
            try {
                String input = scanner.nextLine().trim(); // Lee la entrada
                boolean isFlag = false;
                // Si empieza con F, es acción de marcar/desmarcar
                if (input.toUpperCase().startsWith("F ")) {
                    isFlag = true;
                    input = input.substring(2).trim();
                }
                // Valida formato de entrada
                if (input.length() < 2 || input.length() > 3) throw new NumberFormatException();
                char rowChar = Character.toUpperCase(input.charAt(0)); // Letra de fila
                String colStr = input.substring(1); // Número de columna
                int row, col;
                try {
                    row = rowChar - 'A';
                    col = Integer.parseInt(colStr) - 1;
                } catch (NumberFormatException e) {
                    throw new InputMismatchException();
                }
                // Verifica que la coordenada esté dentro del tablero
                if (row >= 0 && row < size && col >= 0 && col < size) {
                    try {
                        return new Action(isFlag, new Coordinate(row, col));
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Error: Coordenadas fuera de los límites del tablero. Intenta de nuevo.");
                    }
                } else {
                    System.out.println("Coordenadas fuera de rango (fila: A-" + (char)('A'+size-1) + ", columna: 1-" + size + "). Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Usa el formato: A3 para descubrir, F A3 para marcar/desmarcar");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Coordenadas fuera de los límites del tablero. Intenta de nuevo.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }

    // Permite parsear la acción desde un input ya leído (para soportar GUARDAR)
    // Si el input no es válido, lanza excepción
    public static Action askActionFromInput(String input, int size) {
        boolean isFlag = false;
        // Si empieza con F, es acción de marcar/desmarcar
        if (input.toUpperCase().startsWith("F ")) {
            isFlag = true;
            input = input.substring(2).trim();
        }
        // Valida formato de entrada
        if (input.length() < 2 || input.length() > 3) throw new IllegalArgumentException();
        char rowChar = Character.toUpperCase(input.charAt(0));
        String colStr = input.substring(1);
        int row, col;
        try {
            row = rowChar - 'A';
            col = Integer.parseInt(colStr) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        // Verifica que la coordenada esté dentro del tablero
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return new Action(isFlag, new Coordinate(row, col));
        } else {
            throw new IllegalArgumentException();
        }
    }
}
