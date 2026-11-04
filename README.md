# Tarea 2 - Entrega Final 2

## Descripción General
Este repositorio contiene la finalización de la entrega final 2, la cual unifica la arquitectura de control (Parcial 3) y la mejora del modelo de dominio mediante restricciones de negocio (Parcial 4).

## Cambios y Características Implementadas

### 1. Sistema de control (Entrega Parcial 3)
GameController: Implementación del controlador central para manejar el estado del juego.
TurnScheduler: Sistema de turnos basado en recursión pura para el manejo de la cola de acciones (Action Queue), garantizando un flujo seguro y funcional.
Triple Dispatch: Arquitectura implementada y blindada para resolver dinámicamente interacciones complejas (Ataques, Equipamiento, Hechizos) separando la lógica de quién ejecuta y quién recibe la acción.
Corrección de Estado: Solución a problemas de variables ocultas (shadowing) con el parámetro initialHp, asegurando que el daño altere correctamente el estado de las unidades.

### 2. Restricciones y nuevas reglas (Entrega Parcial 4)
Se implementó un sistema estricto de validaciones utilizando la función nativa require() de Scala, lanzando IllegalArgumentException con mensajes descriptivos cuando se violan las reglas del juego:
Estado Vital: Validaciones para impedir que unidades derrotadas (HP <= 0) ejecuten o reciban acciones.
Equipamiento y Armamento:
Los personajes requieren obligatoriamente un arma equipada para atacar.
Restricción estricta de equipamiento según la clase del personaje (ej. Knights con espadas/arcos, White Mages con báculos/varitas) validado mediante Pattern Matching.
Sistema de Magia:
Validación de costo de Maná suficiente antes de castear.
Requisito de portar un arma mágica para poder usar hechizos.
Restricciones de objetivo: Purificación exclusiva para enemigos y Curación exclusiva para personajes aliados.
Tablero y Movimiento: Validación espacial que restringe el movimiento de unidades únicamente hacia paneles aledaños (adyacentes).

### 3. Testing
* Suite de pruebas actualizada para capturar y validar todas las excepciones esperadas utilizando intercept[IllegalArgumentException].
* Cobertura completa de los casos de borde exigidos en los enunciados.