package acciones

class PurificacionTest extends munit.FunSuite:
  test("Purificacion built with default cost"):
    val accion = new Purificacion("A")
    assertEquals(accion.nombre, "A")
    assertEquals(accion.ManaPoints,25)