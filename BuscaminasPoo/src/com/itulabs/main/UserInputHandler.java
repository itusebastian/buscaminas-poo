package com.itulabs.main;

import com.itulabs.model.Coordinate;
import java.util.Scanner;

public class UserInputHandler {
    public static class Action {
        public final boolean isFlag;
        public final Coordinate coord;
        public Action(boolean isFlag, Coordinate coord) {
            this.isFlag = isFlag;
            this.coord = coord;
        }
    }

    public static Action askAction(Scanner scanner, int size) {
        while (true) {
            System.out.print("Introduce coordenada (ejemplo: A3) : ");
            try {
                String input = scanner.nextLine().trim();
                boolean isFlag = false;
                if (input.toUpperCase().startsWith("F ")) {
                    isFlag = true;
                    input = input.substring(2).trim();
                }
                if (input.length() < 2 || input.length() > 3) throw new NumberFormatException();
                char rowChar = Character.toUpperCase(input.charAt(0));
                String colStr = input.substring(1);
                int row = rowChar - 'A';
                int col = Integer.parseInt(colStr) - 1;
                if (row >= 0 && row < size && col >= 0 && col < size) {
                    return new Action(isFlag, new Coordinate(row, col));
                } else {
                    System.out.println("Coordenadas fuera de rango (fila: A-" + (char)('A'+size-1) + ", columna: 1-" + size + "). Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Usa el formato: A3 para descubrir, F A3 para marcar/desmarcar");
            }
        }
    }
}
