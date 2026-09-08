package cl.uchile.dcc
package Map
import scala.collection.mutable.ListBuffer
import cl.uchile.dcc.Jugador.Jugador
import cl.uchile.dcc.Personajes.Personaje

class Panel(val x: Int, val y: Int) {
  val unidades: ListBuffer[Personaje] = ListBuffer.empty[Personaje]
}

