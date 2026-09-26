package utilizables

class CuracionTest extends munit.FunSuite:
  test("Una Curacion tiene el nombre correcto"):
    val pocion = new Curacion()
    assertEquals(pocion.nombre, "Pocion de curacion")
