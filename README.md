# 🎮 Buscaminas en Consola - Examen Final de POO (UPS)

Este proyecto es una implementación en consola del clásico juego **Buscaminas**, desarrollado como parte del examen práctico final de la asignatura **Programación Orientada a Objetos (POO)** de la **Universidad Politécnica Salesiana (UPS)**.

> El propósito de este proyecto es aplicar de forma integral los principios de la POO, manejo de excepciones, persistencia, estructura de paquetes, control de versiones y buenas prácticas de diseño en un entorno colaborativo.

---

## 📋 Requisitos Académicos Cubiertos

- ✔️ Diseño orientado a objetos (Clases, Herencia, Encapsulamiento, Polimorfismo)
- ✔️ Estructura modular y uso del patrón **MVC**
- ✔️ Manejo de excepciones y validación de entradas
- ✔️ Guardado y carga de partidas (persistencia con archivos)
- ✔️ Uso de **Git y GitHub** para control de versiones colaborativo
- ✔️ Código limpio (principios como DRY, KISS)
- ✔️ Documentación y pruebas unitarias básicas

---

## 📐 Reglas del Juego

- Tablero de 10x10 casillas
- 10 minas distribuidas aleatoriamente
- El jugador gana al descubrir todas las casillas sin minas
- El jugador pierde al descubrir una casilla con mina
- Se muestra el número de minas alrededor de cada casilla vacía
- Se pueden **marcar minas sospechosas**
- El tablero se actualiza tras cada acción

---

## 🕹️ Instrucciones de Uso

### Ejecutar el juego

```bash
javac -d out src/**/*.java
java -cp out com.itulabs.Main
