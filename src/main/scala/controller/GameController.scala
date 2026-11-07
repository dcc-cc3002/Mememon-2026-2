package cl.uchile.dcc
package controller

import acciones.{accion, Target}
import combate.Turnos
import unidades.Unidad

/**
  * Controlador principal del juego.
  * En esta clase debes implementar la lógica que conecta las distintas
  * entidades de tu modelo, maneja los turnos, y ejecuta las acciones.
  */
class GameController:
  private var turnos: Turnos = new Turnos()
  private var actual: Option[Unidad] = None
  private var contadorTurnos: Int = 0
  private val incremento: Double = 1.0

  def agregarUnidad(unidad: Unidad): Unit =
    turnos.agregarUnidad(unidad)

  def quitarUnidad(unidad: Unidad): Unit =
    turnos.quitarUnidad(unidad)
    if actual.isDefined && actual.get == unidad then actual = None

  def unidadesEnJuego: List[Unidad] = turnos.unidadesEnBatalla

  def unidadActual: Option[Unidad] = actual

  def turnosJugados: Int = contadorTurnos

  def siguienteTurno(): Option[Unidad] =
    if turnos.unidadesEnBatalla.nonEmpty then
      while turnos.unidadConTurno.isEmpty do
        turnos.aumentarBarras(incremento)
      actual = turnos.unidadConTurno
    actual

  def accionesDe(unidad: Unidad): List[accion] = unidad.acciones


  def ejecutarAccion(nombreAccion: String, objetivo: Target): Boolean =
    if actual.isEmpty then false
    else
      val unidad = actual.get
      val accion = unidad.buscarAccion(nombreAccion)
      if accion.isDefined && unidad.doAction(accion.get, objetivo) then
        turnos.reiniciarBarra(unidad)
        actual = None
        contadorTurnos += 1
        true
      else false

  def reiniciar(): Unit =
    turnos = new Turnos()
    actual = None
    contadorTurnos = 0


