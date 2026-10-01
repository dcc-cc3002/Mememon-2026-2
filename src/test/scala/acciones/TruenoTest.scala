package acciones

class TruenoTest extends munit.FunSuite:
  test("Trueno built with default cost"):
    val accion = new Trueno("A")
    assertEquals(accion.nombre, "A")
    assertEquals(accion.ManaPoints, 20)