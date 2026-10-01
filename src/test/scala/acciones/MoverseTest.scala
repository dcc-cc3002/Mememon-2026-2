package acciones

class MoverseTest extends munit.FunSuite:
  test("built with correct name"):
    val accion = new Moverse("A")
    assertEquals(accion.nombre, "A")