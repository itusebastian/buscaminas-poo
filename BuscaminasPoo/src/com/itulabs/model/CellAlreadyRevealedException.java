
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


// Excepción lanzada cuando se intenta revelar una celda que ya está revelada
public class CellAlreadyRevealedException extends RuntimeException {
    // Constructor por defecto con mensaje estándar
    public CellAlreadyRevealedException() {
        super("La celda ya está revelada.");
    }
    // Constructor que permite especificar un mensaje personalizado
    public CellAlreadyRevealedException(String message) {
        super(message);
    }
}
