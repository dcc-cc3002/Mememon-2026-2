package cl.uchile.dcc
package Accion
import cl.uchile.dcc.Armamento.Arma
import cl.uchile.dcc.Pociones.Pocion
import scala.collection.mutable.ListBuffer

trait Accion:
  val nombre: String

class Atacar extends Accion:
  val nombre: String = "Atacar"

class Moverse extends Accion:
  val nombre: String = "Moverse"

class EquiparArma extends Accion:
  val nombre: String = "Equipar Arma"
  val armas: ListBuffer[Arma] = ListBuffer.empty[Arma]

class ConsumirPocion extends Accion:
  val nombre: String = "Consumir pocion"
  val pociones: ListBuffer[Pocion] = ListBuffer.empty[Pocion]

class Trueno extends Accion:
  val nombre: String = "Trueno"

class Meteorito extends Accion:
  val nombre: String = "Meteorito"

class Curacion extends Accion:
  val nombre: String = "Curacion"

class Purificacion extends Accion:
  val nombre: String = "Purificacion"
