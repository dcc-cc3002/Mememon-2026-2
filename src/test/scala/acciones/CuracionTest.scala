package acciones

class CuracionTest extends munit.FunSuite:
  test("built with default mana cost"):
    val accion = new Curacion("Curacion")
    assertEquals(accion.nombre, "Curacion")
    assertEquals(accion.ManaPoints, 15)