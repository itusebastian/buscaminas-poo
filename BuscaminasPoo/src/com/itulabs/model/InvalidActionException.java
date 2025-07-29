
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


// Excepción lanzada cuando se intenta realizar una acción inválida en el juego
public class InvalidActionException extends RuntimeException {
    // Constructor por defecto con mensaje estándar
    public InvalidActionException() {
        super("Acción inválida.");
    }
    // Constructor que permite especificar un mensaje personalizado
    public InvalidActionException(String message) {
        super(message);
    }
}
