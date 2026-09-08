package cl.uchile.dcc
package Jugador
import cl.uchile.dcc.Personajes.Personaje
import scala.collection.mutable.ListBuffer


class Jugador(val unidades: ListBuffer[Personaje] = ListBuffer[Personaje]()) {

  def derrotado: Boolean = unidades.isEmpty

}