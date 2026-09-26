package utilizables

class FortalezaTest extends munit.FunSuite:
  test("Una Fortaleza tiene el nombre correcto"):
    val pocion = new Fortaleza()
    assertEquals(pocion.nombre, "Pocion de Fortaleza")
