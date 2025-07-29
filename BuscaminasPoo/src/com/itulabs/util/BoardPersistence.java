
// Paquete que contiene utilidades para persistencia de datos
package com.itulabs.util;


import com.itulabs.model.Board;
import java.io.*;

// Clase utilitaria para guardar y cargar el tablero en un archivo (serialización)
public class BoardPersistence {
    // Guarda el estado del tablero en un archivo usando serialización
    public static void saveBoard(Board board, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(board); // Serializa el objeto Board
        }
    }

    // Carga el estado del tablero desde un archivo serializado
    public static Board loadBoard(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Board) ois.readObject(); // Deserializa el objeto Board
        }
    }
}
