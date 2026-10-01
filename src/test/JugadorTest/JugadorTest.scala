package JugadorTest

import munit.FunSuite
import cl.uchile.dcc.Jugador.*
import cl.uchile.dcc.Personajes.*
import scala.collection.mutable.ListBuffer

class JugadorTest extends FunSuite:

  test("Un jugador debe comenzar derrotado si no tiene unidades") {
    val jugador = new Jugador()

    assertEquals(jugador.unidades.isEmpty, true)
    assertEquals(jugador.derrotado, true)
  }

  test("Un jugador no debe estar derrotado si tiene unidades") {
    val caballero = new Caballero("Arturo", 100, 20, 80)
    val unidades = ListBuffer[Personaje](caballero)
    val jugador = new Jugador(unidades)

    assertEquals(jugador.unidades, unidades)
    assertEquals(jugador.derrotado, false)
  }