package acciones

class AtacarTest extends munit.FunSuite:
  test("created with correct name"):
    val accion = new Atacar("atacar")
    assertEquals(accion.nombre, "atacar")
