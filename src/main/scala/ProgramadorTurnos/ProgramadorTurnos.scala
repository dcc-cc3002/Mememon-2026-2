package cl.uchile.dcc
package ProgramadorTurnos
import scala.collection.mutable.ListBuffer
import cl.uchile.dcc.ProgramadorTurnos.Unidad

// Consideraremos como unidad tanto a Jugador como a Enemigo
// Unidad no se debe poder modificar desde afuera

class ProgramadorTurnos {private val unidades: ListBuffer[Unidad] = ListBuffer.empty[Unidad]

  def agregarUnidad(unidad: Unidad): Unit=
    unidades += unidad

  def quitarUnidad(unidad: Unidad): Unit =
    unidades -= unidad

  def reiniciarBarra(): Unit =
    var i = 0

    while i < unidades.length do
      unidades(i).reiniciarBarra()
      i += 1

  def aumentarBarras(cantidad: Int): Unit =
    var i = 0

    while i < unidades.length do {
      unidades(i).aumentarBarra(cantidad)
      i += 1
    }

  def barraCompleta(unidad: Unidad): Boolean =
    unidad.barraDeAccion >= unidad.barraMaxima

  def excesoBarra(unidad: Unidad): Int =
    unidad.barraDeAccion - unidad.barraMaxima

  def unidadesConBarraCompleta(): ListBuffer[Unidad] =
    val completas: ListBuffer[Unidad] =
      ListBuffer.empty[Unidad]

    var i = 0

    while i < unidades.length do
      if barraCompleta(unidades(i)) then
        completas += unidades(i)

      i += 1

    completas

  def ordenarPorExceso(completas: ListBuffer[Unidad]): Unit =
    var i = 0

    while i < completas.length - 1 do
      if excesoBarra(completas(i)) < excesoBarra(completas(i + 1)) then
        val aux = completas(i)
        completas(i) = completas(i + 1)
        completas(i + 1) = aux

      i += 1

  def unidadConTurno(): Unidad =
    val completas = unidadesConBarraCompleta()

    ordenarPorExceso(completas)

    completas(0)
}

