package MapTest

import munit.FunSuite
import cl.uchile.dcc.Map.*
import cl.uchile.dcc.Personajes.*

class MapTest extends FunSuite:

  test("Un panel debe tener las coordenadas correctas") {
    val panel = new Panel(2, 3)

    assertEquals(panel.x, 2)
    assertEquals(panel.y, 3)
  }

  test("Un panel debe comenzar con una lista de unidades vacía") {
    val panel = new Panel(2, 3)

    assertEquals(panel.unidades.isEmpty, true)
  }

  test("Un panel debe comenzar con una lista de paneles aledaños vacía") {
    val panel = new Panel(2, 3)

    assertEquals(panel.panelesAledanhos.isEmpty, true)
  }