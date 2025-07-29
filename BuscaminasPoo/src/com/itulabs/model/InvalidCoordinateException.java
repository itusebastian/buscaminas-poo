
// Paquete que contiene las clases del modelo del juego
package com.itulabs.model;


// Excepción lanzada cuando una coordenada está fuera del rango válido del tablero
public class InvalidCoordinateException extends RuntimeException {
    // Constructor por defecto con mensaje estándar
    public InvalidCoordinateException() {
        super("Coordenada inválida.");
    }
    // Constructor que permite especificar un mensaje personalizado
    public InvalidCoordinateException(String message) {
        super(message);
    }
}
