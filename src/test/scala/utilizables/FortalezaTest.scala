package utilizables

class FortalezaTest extends munit.FunSuite:
  var pocion: Fortaleza = null

  override def beforeEach(context: BeforeEach): Unit =
    pocion = new Fortaleza("A")

  test("poción de fortaleza con nombre dado"):
    assert(pocion.nombre == "A")

  test("pociones de Fortaleza mismo nombre soniguales"):
    val otra = new Fortaleza("A")
    assertEquals(pocion, otra)
    assertEquals(otra, pocion)

  test(" pociones de Fortaleza con distinto nombre no  iguales"):
    assertNotEquals(pocion, new Fortaleza("Otra"))

  test("poción de fortaleza y curacion con mismo nombre no iguales"):
    val a: Pocion = pocion
    val b: Pocion = new Curacion("A")
    assertNotEquals(a, b)
    assertNotEquals(b, a)