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

## 🧪 Pruebas Unitarias

El proyecto incluye pruebas unitarias desarrolladas con JUnit para validar el funcionamiento de las clases principales y asegurar la calidad del software. Las pruebas cubren componentes como:

- `Board`, `MineTile`, `NormalTile`, `Coordinate`, `UserInputHandler`, `BoardPersistence`, `MineGenerator`, `TileDetector`

Para ejecutar las pruebas:

```bash
javac -cp "/ruta/a/junit-4.13.2.jar:/ruta/a/hamcrest-core-1.3.jar" -d out src/**/*.java test/**/*.java
java -cp "out:/ruta/a/junit-4.13.2.jar:/ruta/a/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore com.itulabs.tests.BoardTest
```

---

## 👥 Participación del Equipo

El desarrollo fue colaborativo, con contribuciones de:

- **Diana Calderon**: renderizado en consola, clases de casillas, pruebas de modelo.
- **Nicole Ramos**: generación de minas, excepciones personalizadas, pruebas de lógica y servicio.
- **Steve Tutillo**: clase `Coordinate`, lógica de minas adyacentes, interfaz `TileBehavior`.
- **Sebastian Iturralde**: estructura base, lógica principal, persistencia, pruebas y documentación.

Historial completo de contribuciones: [Commits en GitHub](https://github.com/itusebastian/buscaminas-poo/commits/main)

---

## 📝 Informe y Buenas Prácticas

El proyecto sigue principios de código limpio (DRY, KISS), refactorización continua y control de versiones con GitHub. Se aplicó el patrón MVC y se documentaron las clases y métodos principales. Se enfrentaron y resolvieron dificultades mediante comunicación y trabajo en equipo, aprendiendo sobre encapsulamiento, polimorfismo y pruebas automatizadas.

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
```

---

### Clonar el repositorio

Para obtener el código fuente y comenzar a trabajar con el proyecto, primero clona el repositorio desde GitHub:

```bash
git clone https://github.com/itusebastian/buscaminas-poo.git
```

---

### Opción: Importar y ejecutar en Eclipse

1. Abre Eclipse y selecciona **File > Import > Existing Projects into Workspace**.
2. Selecciona la carpeta del repositorio clonado (`buscaminas-poo`).
3. Asegúrate de que la estructura de paquetes esté en `src/`.
4. Compila y ejecuta la clase principal `com.itulabs.main.Main`.
5. Para ejecutar pruebas unitarias, asegúrate de agregar JUnit a las dependencias del proyecto.

---

Para más detalles sobre la estructura y funcionamiento, revisa la documentación incluida y los comentarios en el código fuente.
