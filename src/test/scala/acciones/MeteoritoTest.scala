package acciones

class MeteoritoTest extends munit.FunSuite:
  test("Meteorito built with default mana cost"):
    val accion = new Meteorito("A")
    assertEquals(accion.nombre, "A")
    assertEquals(accion.ManaPoints, 50)