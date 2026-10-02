package combate

import scala.collection.mutable
import unidades.Unidad


class Turnos:
  private val unidades : mutable.ListBuffer[Unidad] = mutable.ListBuffer()
  private val barras : mutable.Map[Unidad,Double] = mutable.Map()

  def agregarUnidad(unidad: Unidad): Unit =
    unidades += unidad
    barras(unidad) = 0.0

  def quitarUnidad(unidad: Unidad): Unit =
    unidades -= unidad
    barras -=unidad

  def unidadesEnBatalla: List[Unidad] = unidades.toList


  def barraDe(unidad: Unidad): Double = barras(unidad)


  def maxbarraDe(unidad: Unidad): Double = unidad.BarraAccion

  def reiniciarBarra(unidad: Unidad): Unit =
    barras(unidad) = 0.0


  def aumentarBarras(cantidad:Double): Unit =
    for unidad <- unidades do
      barras(unidad) = barras(unidad) + cantidad

  def completoBarra(unidad: Unidad): Boolean =
    barras(unidad) >= unidad.BarraAccion

  def unidadesConTurno: List[Unidad] =
    val completadas: mutable.ListBuffer[Unidad] = mutable.ListBuffer()

    for unidad <- unidades do
      if completoBarra(unidad) then
        completadas += unidad

    def excedente(unidad: Unidad): Double =
      barras(unidad) - unidad.BarraAccion

    val ordenadas: mutable.ListBuffer[Unidad] = mutable.ListBuffer()
    while completadas.nonEmpty do
      var mejor: Unidad = completadas(0)
      for unidad <- completadas do
        if excedente(unidad) > excedente(mejor) then
          mejor = unidad

      ordenadas+=mejor
      completadas -= mejor

    ordenadas.toList

  def unidadConTurno: Option[Unidad] =
    val conTurno = unidadesConTurno
    if conTurno.isEmpty then
      None
    else
      Some(conTurno(0))
      
