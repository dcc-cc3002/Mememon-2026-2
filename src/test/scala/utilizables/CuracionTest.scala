package utilizables

class CuracionTest extends munit.FunSuite:
  test("Una Curacion tiene creada con nombre dado"):
    val pocion = new Curacion("Pocion de curacion A")
    assertEquals(pocion.nombre, "Pocion de curacion A")
  test("Dos curaciones con nombres distintos"):
    val pocion1 = new Curacion("Pocion de curacion A")
    val pocion2 = new Curacion("Pocion de curacion B")
    assertNotEquals(pocion1.nombre, pocion2.nombre)
