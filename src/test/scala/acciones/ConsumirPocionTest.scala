package acciones

import utilizables.{Curacion => PocionCuracion, Fortaleza}


class ConsumirPocionTest extends munit.FunSuite:
  test("Created with name and list given"):
    val curacion = new PocionCuracion("Curacion A")
    val fortaleza = new Fortaleza("Fortaleza A")
    val accion = new ConsumirPocion("Consumir pocion", List(curacion, fortaleza))
    assertEquals(accion.nombre, "Consumir pocion")
    assertEquals(accion.PosibleObjects, List(curacion,fortaleza))